package com.springwalk.sample.controller;

import com.google.gson.Gson;
import com.springwalk.sample.crypto.CryptoTools;
import com.springwalk.sample.model.*;
//import com.thoughtworks.xstream.XStream;
//import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.*;
import javax.xml.bind.DatatypeConverter;
import java.io.*;
import java.security.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by jgonzalezg on 19/10/2016.
 */

@RestController
public class SuitabilityTestController {

    Gson gson = new Gson();
    @RequestMapping(value = "/avaloqproxy", method = RequestMethod.POST)
    public ResponseEntity<String> avaloqproxy(@RequestBody String rq, @RequestHeader("Date") String date) {
        String jsonOut = "";
        System.out.println("Encrypt IN:" + rq);
        try {
            rq = CryptoTools.decryptWithAESKey(rq, date);
            //mapear request a genericRequest POJO
            AvaloqGenericRequest genericRequest = gson.fromJson(rq, AvaloqGenericRequest.class);
            switch (genericRequest.getService()) {
                case "calculateProfile":
                    genericRequest.setContent(calculateProfileService(genericRequest.getContent()));
                    break;
                case "verificarPerfil":
                    genericRequest.setContent(verifyCustomForm(genericRequest.getContent()));
                    break;
                case "crearOrdenNuevoCuestionario":
                    genericRequest.setContent(newCustomForm(genericRequest.getContent()));
                    break;
                case "crearOrdenModificacionCuestionario":
                    genericRequest.setContent(renewCustomForm(genericRequest.getContent()));
                    break;
                case "descartarOrdenCuestionario":
                    genericRequest.setContent(discardCustomForm(genericRequest.getContent()));
                    break;
                case "recuperarCuestionarios":
                    genericRequest.setContent(getBPforms(genericRequest.getContent()));
                    break;
                case "getDocumento":
                    genericRequest.setContent(getDocumentPdfRest(genericRequest.getContent()));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid service: " + genericRequest.getService());
            }
            jsonOut = gson.toJson(genericRequest);
            jsonOut = CryptoTools.encryptWithAESKey(jsonOut, date);
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseEntity<String>("", getHeaders(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(jsonOut, getHeaders(), HttpStatus.OK);
    }

    private String calculateProfileService(String rq) {
        SuitabilityResponse response;//SuitabilityRequest map
        SuitabilityRequest request = gson.fromJson(rq, SuitabilityRequest.class);
        response = new SuitabilityResponse();
        List<RequestError> questionErrorList = new ArrayList<RequestError>();
        RequestError questionError = new RequestError();
        questionError.setCodError("003");
        questionError.setDescError("RESPUESTA NO VALIDA");
        questionErrorList.add(questionError);
        System.out.println("TEMPLATE: "+request.getTemplate());
        if (request != null) {
            //System.out.println(request.getQuestion().get(0).getAnswer());
            if (request.getTemplate().equals("121")) {
                //PRUEBA OK
                response.setStatus("OK");
                response.setIdAvaloq("123456789AVAQ");
                response.setProfile("535012");
                List<Question> questionList = new ArrayList<Question>();
                for (Question rqQuestion : request.getQuestion()) {
                    Question rsQuestion = new Question();
                    //rsQuestion.setAnswer(rqQuestion.getAnswer());
                    rsQuestion.setQuestionId(rqQuestion.getQuestionId());
                    questionList.add(rsQuestion);
                }
                response.setQuestion(questionList);
            }else if(request.getTemplate().equals("120")){
                //PRUEBA OK
                response.setStatus("OK");
                response.setIdAvaloq("9999999AVAQ");
                response.setProfile("535011");
                List<Question> questionList = new ArrayList<Question>();
                for (Question rqQuestion : request.getQuestion()) {
                    Question rsQuestion = new Question();
                    //rsQuestion.setAnswer(rqQuestion.getAnswer());
                    rsQuestion.setQuestionId(rqQuestion.getQuestionId());
                    questionList.add(rsQuestion);
                }
                response.setQuestion(questionList);
            } else {
                //PRUEBA ERROR
                response.setStatus("KO");
                List<RequestError> errorList = new ArrayList<RequestError>();
                RequestError error = new RequestError();
                error.setCodError("002");
                error.setDescError("ERROR DE VALIDACION");
                errorList.add(error);
                response.setError(errorList);

                List<Question> questionList = new ArrayList<Question>();
                for (Question rqQuestion : request.getQuestion()) {
                    Question rsQuestion = new Question();
                    if (rqQuestion.getQuestionId().equals("VEC_ADV_CF_SUIV2PJ_g1_q1")) {
                        rsQuestion.setError(questionErrorList);
                    }
                    //rsQuestion.setAnswer(rqQuestion.getAnswer());
                    rsQuestion.setQuestionId(rqQuestion.getQuestionId());
                    questionList.add(rsQuestion);
                }
                response.setQuestion(questionList);
            }
        } else {
            response.setStatus("KO");
            response.setIdAvaloq("");
            response.setProfile("");
            List<RequestError> errorList = new ArrayList<RequestError>();
            RequestError error = getRequestNullError();
            errorList.add(error);
            response.setError(errorList);
        }
        return gson.toJson(response);
    }

    private String getBPforms(String rq) {
        List<bpCustomFormResponse> reponseList = new ArrayList<bpCustomFormResponse>();
        bpCustomFormResponse responseDummy = new bpCustomFormResponse();
        bpCustomFormRequest request = gson.fromJson(rq, bpCustomFormRequest.class);
        RequestError questionError = new RequestError();
        questionError.setCodError("001");
        questionError.setDescError("BP NO ENCONTRAD0 ERROR");
        if (request != null) {
            if (request.getIdBP().equals("54321")) {
                responseDummy.setError(questionError);
                reponseList.add(responseDummy);
            } else {
                //PRUEBA Ok
                if(request.getEstado().equals("Done")){
                    for (int i = 0; i <= 6; i++) {
                        bpCustomFormResponse response = new bpCustomFormResponse();
                        response.setEstado("COMPLETED");
                        response.setTipo("SUITABILITY");
                        response.setVersion("2");
                        response.setFecha(new Date().toString());
                        response.setCuestionId("SUI200" + i);
                        reponseList.add(response);
                    }
                }else{
                    for (int i = 0; i <= 4; i++) {
                        bpCustomFormResponse response = new bpCustomFormResponse();
                        response.setEstado("COMPLETED");
                        response.setTipo("SUITABILITY");
                        response.setVersion("1");
                        response.setFecha(new Date().toString());
                        response.setCuestionId("SUI000" + i);
                        reponseList.add(response);
                    }
                }
            }
        } else {
            RequestError error = getRequestNullError();
            responseDummy.setError(error);
            reponseList.add(responseDummy);
        }
        return gson.toJson(reponseList);
    }

    private String renewCustomForm(String rq) {
        RenewCustomFormResponse response = new RenewCustomFormResponse();
        RenewCustomFormRequest request = gson.fromJson(rq, RenewCustomFormRequest.class);
        RequestError questionError = new RequestError();
        questionError.setCodError("001");
        questionError.setDescError("ID NO ENCONTRAD0 ERROR");
        if (request != null) {
            if (request.getIdCustomForm().equals("SUI0001")) {
                //HOLD
                RequestError error = new RequestError();
                error.setCodError("0001");
                error.setDescError("ID:" + request.getIdCustomForm() + "  Orden ya existente");
                response.setIdOrdenHold("ORDENHOLD-" + getSaltString());

            } else {
                //PRUEBA OK
                response.setIdOrden("ORDERNEW-" + getSaltString());
            }
        } else {
            RequestError error = getRequestNullError();
            response.setError(error);
        }
        return gson.toJson(response);
    }

    private String discardCustomForm(String rq) {
        DiscardCustomFormResponse response = new DiscardCustomFormResponse();
        DiscardCustomFormRequest request = gson.fromJson(rq, DiscardCustomFormRequest.class);
        RequestError questionError = new RequestError();
        questionError.setCodError("001");
        questionError.setDescError("ID NO ENCONTRAD0 ERROR");
        if (request != null) {

        } else {
            RequestError error = getRequestNullError();
            response.setError(error);

        }
        return gson.toJson(response);
    }

    private static RequestError getRequestNullError() {
        RequestError error = new RequestError();
        error.setCodError("001");
        error.setDescError("Body null");
        return error;
    }

    private String verifyCustomForm(String rq) {
        VerifyCustomFormResponse response = new VerifyCustomFormResponse();
        VerifyCustomFormRequest request = gson.fromJson(rq, VerifyCustomFormRequest.class);
        RequestError questionError = new RequestError();
        questionError.setCodError("001");
        questionError.setDescError("ID NO ENCONTRAD0 ERROR");
        if (request != null) {
            response.setIdCustomForm("CF-" + getSaltString());
            response.setIdDocument("DOCU-" + getSaltString());
        } else {
            RequestError error = getRequestNullError();
            response.setError(error);

        }
        return gson.toJson(response);
    }

    private String newCustomForm(String rq) {
        createNewSuitabilityResponse response = new createNewSuitabilityResponse();
        createNewSuitabilityRequest request = gson.fromJson(rq, createNewSuitabilityRequest.class);
        if (request != null) {
            response.setIdBp(getSaltString());
            response.setIdOrden(getSaltString());
        } else {
            RequestError error = getRequestNullError();
            response.setError(error);
        }
        return gson.toJson(response);
    }

    @RequestMapping(value = "/encryptTest", method = RequestMethod.POST)
    public ResponseEntity<String> encryptTest(@RequestBody String request) {
        if (request != null) {
            System.out.println(request);
            try {
                KeyStore keyStore = KeyStore.getInstance("JCEKS");
                InputStream stream = SuitabilityTestController.class.getResourceAsStream("/00D0E0000000McO.jks");
                keyStore.load(stream, "Vector092016".toCharArray());
                //Key key = keyStore.getKey("CertRequest", "Vector092016".toCharArray());
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(Cipher.ENCRYPT_MODE, keyStore.getCertificate("CertRequest"));
                byte[] cipherText = cipher.doFinal(request.getBytes());
                System.out.println("cipher: " + new String(cipherText));
                return new ResponseEntity<String>(new String(cipherText), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<String>("", getHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<String>(request, getHeaders(), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/encryptAes", method = RequestMethod.POST)
    public ResponseEntity<String> encryptAes(@RequestBody String request, @RequestHeader("Date") String date) {
        if (request != null) {
            System.out.println(request);
            try {
                System.out.println("Original date:" + date);
                System.out.println("IVParam date:" + CryptoTools.getIvParameter(date));
                System.out.println("plain : " + CryptoTools.encryptWithAESKey(request, date));
                return new ResponseEntity<String>(CryptoTools.encryptWithAESKey(request, date), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<String>("", getHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<String>(request, getHeaders(), HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/decryptTest", method = RequestMethod.POST)
    public ResponseEntity<String> decryptTest(@RequestBody String request, @RequestHeader("Date") String date) {
        if (request != null) {
            System.out.println(request);
            System.out.println(date);
            try {
                System.out.println("plain : " + CryptoTools.decryptWithAESKey(request, date));
                return new ResponseEntity<String>(CryptoTools.decryptWithAESKey(request, date), HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<String>("", getHeaders(), HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<String>("", getHeaders(), HttpStatus.BAD_REQUEST);
    }

    private String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    protected Boolean checkOnHold(String id) {
        //Comprobar formularios en curso Avaloq
        if ("123456789".equals(id)) {
            return true;
        }
        return false;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Content-Type", "application/json");
        headers.add("Date", "1997-01-31 09:26:50.120");
        return headers;
    }

    private String getDocumentPdf(String rq) {
        DocumentCustomFormResponse response = new DocumentCustomFormResponse();
        System.out.println(rq);
        DocumentCustomFormRequest request = gson.fromJson(rq, DocumentCustomFormRequest.class);
        RequestError questionError = new RequestError();
        questionError.setCodError("001");
        questionError.setDescError("ID NO ENCONTRAD0 ERROR");
        if (request != null) {
            try {
                response.setBlobPDF(encode(request.getIdCustomForm(), false));
            } catch (Exception e) {
                RequestError error = getRequestNullError();
                response.setError(error);
            }
        } else {
            RequestError error = getRequestNullError();
            response.setError(error);
        }
        return gson.toJson(response);
    }

    private String getDocumentPdfRest(String rq){
        DocumentCustomFormResponse response = new DocumentCustomFormResponse();
        DocumentCustomFormRequest request = gson.fromJson(rq, DocumentCustomFormRequest.class);
        RequestError questionError = new RequestError();
        questionError.setCodError("001");
        questionError.setDescError("ID NO ENCONTRAD0 ERROR");
        System.out.println("FILENAME REQUEST "+request);
        if (request != null) {
            try {
                ClassLoader classLoader = getClass().getClassLoader();
                File file = new File(classLoader.getResource("avaloqPreview.pdf").getFile());
                System.out.println("FILE 1"+file);
                System.out.println("length 1"+file.length());
                int length = (int) file.length();
                BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
                System.out.println("BufferedInputStream "+reader.toString());
                byte[] bytes = new byte[length];
                reader.read(bytes, 0, length);
                reader.close();
                String res = DatatypeConverter.printBase64Binary(bytes);
                System.out.println("bytes [] "+bytes.length);
                System.out.println("bytes String "+res);
                System.out.println("bytes String "+bytes.toString());
                byte[] base64EncodedData = Base64.encodeBase64(bytes,false);

                byte[] decodedBytes = Base64.decodeBase64(bytes);
                System.out.println("decodedBytes "+base64EncodedData);
                response.setBlobPDF(res);
            } catch (Exception e) {
                RequestError error = getRequestNullError();
                response.setError(error);
            }
        } else {
            RequestError error = getRequestNullError();
            response.setError(error);
        }
        return gson.toJson(response);
    }


    /**
     * This method converts the content of a source file into Base64 encoded data and saves that to a target file.
     * If isChunked parameter is set to true, there is a hard wrap of the output  encoded text.
     */
    private static String encode(String sourceFile, boolean isChunked) throws Exception {

        byte[] base64EncodedData = Base64.encodeBase64(loadFileAsBytesArray(sourceFile), isChunked);

        //writeByteArraysToFile(targetFile, base64EncodedData);

        return base64EncodedData.toString();
    }

    public static void decode(String sourceFile, String targetFile) throws Exception {

        byte[] decodedBytes = Base64.decodeBase64(loadFileAsBytesArray(sourceFile));

        writeByteArraysToFile(targetFile, decodedBytes);
    }

    /**
     * This method loads a file from file system and returns the byte array of the content.
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    public static byte[] loadFileAsBytesArray(String fileName) throws Exception {
        System.out.println("FILENAME "+fileName);
        File file = new File(fileName);
        System.out.println("FILE "+file);
        int length = (int) file.length();
        System.out.println("length "+length);
        BufferedInputStream reader = new BufferedInputStream(new FileInputStream(file));
        System.out.println("BufferedInputStream "+reader);
        byte[] bytes = new byte[length];
        reader.read(bytes, 0, length);
        reader.close();
        return bytes;

    }

    /**
     * This method writes byte array content into a file.
     *
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void writeByteArraysToFile(String fileName, byte[] content) throws IOException {

        File file = new File(fileName);
        BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
        writer.write(content);
        writer.flush();
        writer.close();
    }

    @RequestMapping(value="/getPortfolio", method=RequestMethod.POST)
    public ResponseEntity<ClientPortfolioResponse> getPortfolio(@RequestBody String request){
        ClientPortfolioResponse  response = new  ClientPortfolioResponse();
        if (request != null) {
            try {
                String jsonBody = "{\n" +
                        "  \"clientName\": \"nombre cliente\",\n" +
                        "  \"bp\": [{\n" +
                        "    \"name\": \"NOMBRE BP\",\n" +
                        "    \"container\": [{\n" +
                        "       \"name\": \"NOMBRE CONTAINER\",\n" +
                        "        \"mac\": [{\n" +
                        "          \"id\": \"NOMBRE MAC\",\n" +
                        "          \"name\": \"100000\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"NOMBRE MAC2\",\n" +
                        "          \"name\": \"500000\"\n" +
                        "        }]\n" +
                        "    },\n" +
                        "    {\n" +
                        "       \"name\": \"NOMBRE CONTAINER2\",\n" +
                        "        \"mac\": [{\n" +
                        "          \"id\": \"NOMBRE MAC\",\n" +
                        "          \"name\": \"1000\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"NOMBRE MAC2\",\n" +
                        "          \"name\": \"5000\"\n" +
                        "        }]\n" +
                        "    }]\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"name\": \"NOMBRE BP2\",\n" +
                        "    \"container\": [{\n" +
                        "       \"name\": \"NOMBRE CONTAINER\",\n" +
                        "        \"mac\": [{\n" +
                        "          \"id\": \"NOMBRE MAC\",\n" +
                        "          \"name\": \"100000\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"NOMBRE MAC2\",\n" +
                        "          \"name\": \"500000\"\n" +
                        "        }]\n" +
                        "    },\n" +
                        "    {\n" +
                        "       \"name\": \"NOMBRE CONTAINER2\",\n" +
                        "        \"mac\": [{\n" +
                        "          \"id\": \"NOMBRE MAC\",\n" +
                        "          \"name\": \"1000\"\n" +
                        "        },\n" +
                        "        {\n" +
                        "          \"id\": \"NOMBRE MAC2\",\n" +
                        "          \"name\": \"5000\"\n" +
                        "        }]\n" +
                        "    }]\n" +
                        "  }]\n" +
                        "}";

                response = gson.fromJson(jsonBody, ClientPortfolioResponse.class);
            } catch (Exception e) {
                return new ResponseEntity<ClientPortfolioResponse>(response,HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<ClientPortfolioResponse>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<ClientPortfolioResponse>(response,HttpStatus.OK);
    }

    /*@RequestMapping(value="/testQuestionList", method=RequestMethod.POST)
    public ResponseEntity<String> testQuestionList(@RequestBody QuestionListRQ request){

        System.out.println("LANG :"+request.getLang());
        System.out.println("objList ID:"+request.getObjList().getObj().get(0).getAvqId());
        System.out.println("questType :"+request.getQuestType());
        System.out.println("questVersion :"+request.getQuestVersion());
        System.out.println("questStatus :"+request.getQuestStatus());

        XStream xstream = new XStream();
        xstream.alias("content", QuestionListRQ.class);
        String XML_out = xstream.toXML(request); //Nos retorna un String con la estructura en forma de XML

        System.out.println("POJO TO XMLOUT :"+"\n"+XML_out);

        return new ResponseEntity<String>("OK",HttpStatus.OK);
    }

    @RequestMapping(value="/testQuestionListXML", method=RequestMethod.POST)
    public ResponseEntity<String> testQuestionListXML(@RequestBody String request){

        XStream xstream = new XStream(new JettisonMappedXmlDriver());
        xstream.alias("content", QuestionListRQ.class);
        QuestionListRQ content = (QuestionListRQ)xstream.fromXML(request);

        System.out.println("READ XML FROM JSON :"+ xstream.toXML(content));


        return new ResponseEntity<String>("OK",HttpStatus.OK);
    }*/


}