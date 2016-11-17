package com.springwalk.sample.controller;

import com.google.gson.Gson;
import com.springwalk.sample.crypto.CryptoTools;
import com.springwalk.sample.model.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.*;
import java.io.InputStream;
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
   /* @RequestMapping(value="/calculateprofile", method=RequestMethod.POST)
    public ResponseEntity<SuitabilityResponse> calculateProfile(@RequestBody SuitabilityRequest request){
        SuitabilityResponse response  = new SuitabilityResponse();

        List<RequestError> questionErrorList = new ArrayList<RequestError>();
        RequestError questionError = new RequestError();
        questionError.setCodError("003");
        questionError.setDescError("ANSWER NOT VALID");
        questionErrorList.add(questionError);

        if(request != null){
            if(request.getQuestion().get(0).getAnswer().equals("Obtener un rendimiento de media superior en un 5% a la inflación.")) {
                //PRUEBA OK
                response.setStatus("OK");
                response.setIdAvaloq("123456789AVAQ");
                response.setProfile("Moderado");

                List<Question> questionList = new ArrayList<Question>();
                for (Question rqQuestion : request.getQuestion()) {
                    Question rsQuestion = new Question();
                    rsQuestion.setAnswer(rqQuestion.getAnswer());
                    rsQuestion.setQuestionId(rqQuestion.getQuestionId());
                    questionList.add(rsQuestion);
                }
                response.setQuestion(questionList);
                //PRUEBA ERROR
            }else{
                //PRUEBA OK
                response.setStatus("KO");

                List<RequestError> errorList = new ArrayList<RequestError>();
                RequestError error = new RequestError();
                error.setCodError("002");
                error.setDescError("ANSWER VALIDATION ERROR");
                errorList.add(error);
                response.setError(errorList);



                List<Question> questionList = new ArrayList<Question>();
                for (Question rqQuestion : request.getQuestion()) {
                    Question rsQuestion = new Question();
                    if(rqQuestion.getQuestionId().equals("VEC_ADV_CF_SUIV2PJ_g1_q1")){
                        rsQuestion.setError(questionErrorList);
                    }
                    rsQuestion.setAnswer(rqQuestion.getAnswer());
                    rsQuestion.setQuestionId(rqQuestion.getQuestionId());
                    questionList.add(rsQuestion);
                }

                response.setQuestion(questionList);
            }
        }else{
            response.setStatus("KO");
            response.setIdAvaloq("");
            response.setProfile("");

            List<RequestError> errorList = new ArrayList<RequestError>();
            RequestError error = new RequestError();
            error.setCodError("001");
            error.setDescError("Body null");
            errorList.add(error);

            response.setError(errorList);

        }
        return new ResponseEntity<SuitabilityResponse>(response,HttpStatus.OK);
    }*/

    @RequestMapping(value="/avaloqproxy", method=RequestMethod.POST)
    public ResponseEntity<String> avaloqproxy(@RequestBody String rq, @RequestHeader("Date") String date){
        String jsonOut = "";
        System.out.println("Encrypt IN:"+ rq);
        try {
            rq = CryptoTools.decryptWithAESKey(rq,date);
            System.out.println("Decrypt IN:"+ rq);
            //mapear request a genericRequest POJO
            AvaloqGenericRequest genericRequest = gson.fromJson(rq, AvaloqGenericRequest.class);
            System.out.println("Decrypt IN:"+ rq);
            System.out.println("Service:"+ genericRequest.getService());
            switch (genericRequest.getService()) {
                case "calculateProfile":
                    genericRequest.setContent(calculateProfileService(genericRequest.getContent()));
                    break;
                case "verificarPerfil":
                    break;
                case "crearOrdenNuevoCuestionario":
                    break;
                case "crearOrdenModificacionCuestionario":
                    break;
                case "descartarOrdenCuestionario":
                    break;
                case "recuperarCuestionarios":
                    genericRequest.setContent(getBPforms(genericRequest.getContent()));
                    break;
                case "getDocumento":
                    break;
                default:
                    throw new IllegalArgumentException("Invalid service: " + genericRequest.getService());
            }
            jsonOut = gson.toJson(genericRequest);
            System.out.println("OUT:"+ jsonOut);
            jsonOut = CryptoTools.encryptWithAESKey(jsonOut,date);
            System.out.println("Encrypt OUT:"+ jsonOut);
        } catch (Exception e) {
            e.printStackTrace();
            new ResponseEntity<String>("",getHeaders(),HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>(jsonOut,getHeaders(),HttpStatus.OK);
    }

    private String calculateProfileService(String rq) {
        SuitabilityResponse response;//SuitabilityRequest map
        SuitabilityRequest request = gson.fromJson(rq, SuitabilityRequest.class);
        response = new SuitabilityResponse();
        List<RequestError> questionErrorList = new ArrayList<RequestError>();
        RequestError questionError = new RequestError();
        questionError.setCodError("003");
        questionError.setDescError("ANSWER NOT VALID");
        questionErrorList.add(questionError);

        if(request != null){
            System.out.println(request.getQuestion().get(0).getAnswer());
            if(request.getQuestion().get(0).getAnswer().equals("Obtener un rendimiento de media superior en un 5% a la inflación.")) {
                //PRUEBA OK
                response.setStatus("OK");
                response.setIdAvaloq("123456789AVAQ");
                response.setProfile("Moderado");

                List<Question> questionList = new ArrayList<Question>();
                for (Question rqQuestion : request.getQuestion()) {
                    Question rsQuestion = new Question();
                    rsQuestion.setAnswer(rqQuestion.getAnswer());
                    rsQuestion.setQuestionId(rqQuestion.getQuestionId());
                    questionList.add(rsQuestion);
                }
                response.setQuestion(questionList);
                //PRUEBA ERROR
            }else{
                //PRUEBA OK
                response.setStatus("KO");
                List<RequestError> errorList = new ArrayList<RequestError>();
                RequestError error = new RequestError();
                error.setCodError("002");
                error.setDescError("ANSWER VALIDATION ERROR");
                errorList.add(error);
                response.setError(errorList);

                List<Question> questionList = new ArrayList<Question>();
                for (Question rqQuestion : request.getQuestion()) {
                    Question rsQuestion = new Question();
                    if(rqQuestion.getQuestionId().equals("VEC_ADV_CF_SUIV2PJ_g1_q1")){
                        rsQuestion.setError(questionErrorList);
                    }
                    rsQuestion.setAnswer(rqQuestion.getAnswer());
                    rsQuestion.setQuestionId(rqQuestion.getQuestionId());
                    questionList.add(rsQuestion);
                }
                response.setQuestion(questionList);
            }
        }else{
            response.setStatus("KO");
            response.setIdAvaloq("");
            response.setProfile("");
            List<RequestError> errorList = new ArrayList<RequestError>();
            RequestError error = new RequestError();
            error.setCodError("001");
            error.setDescError("Body null");
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
        if(request != null){
            if(request.getIdBP().equals("54321")) {
                responseDummy.setError(questionError);
                reponseList.add(responseDummy);
            }else{
                //PRUEBA OK
                responseDummy.setEstado("COMPLETED");
                responseDummy.setTipo("SUITABILITY");
                responseDummy.setVersion("1");
                responseDummy.setFecha(new Date().toString());
                for (int i = 0;i <= 4 ;i++) {
                    bpCustomFormResponse response = new bpCustomFormResponse();
                    response = responseDummy;
                    response.setCuestionId("SUI000"+i);
                    reponseList.add(response);
                    }
                }
        }else{
            RequestError error = new RequestError();
            error.setCodError("001");
            error.setDescError("Body null");
            responseDummy.setError(error);
            reponseList.add(responseDummy);
        }
        return gson.toJson(reponseList);
    }

    @RequestMapping(value="/createNewSuitabilityTest", method=RequestMethod.POST)
    public ResponseEntity<createNewSuitabilityResponse> createNewSuitabilityTest(@RequestBody createNewSuitabilityRequest request){
        createNewSuitabilityResponse response  = new createNewSuitabilityResponse();

        if(request != null){
            if(checkOnHold(request.getIdSuitabilityAvaloq())){
                response.setStatus("KO");
                RequestError error = new RequestError();
                error.setCodError("666");
                error.setDescError("Avaloq Suitability Test on hold status");
                response.setError(error);

            }else{
                System.out.println(request.getIsRenew());
                if(request.getIsRenew()) {
                    //RENOVACION
                    response.setStatus("OK");
                    response.setIdSuitabilityAvaloq(request.getIdSuitabilityAvaloq());
                }else{
                    //NUEVO
                    response.setStatus("OK");
                    response.setIdSuitabilityAvaloq(getSaltString());
                }
            }
        }else{
            response.setStatus("KO");
            RequestError error = new RequestError();
            error.setCodError("001");
            error.setDescError("Body null");
            response.setError(error);
        }
        return new ResponseEntity<createNewSuitabilityResponse>(response,getHeaders(),HttpStatus.OK);
    }

    @RequestMapping(value="/encryptTest", method=RequestMethod.POST)
    public ResponseEntity<String> encryptTest(@RequestBody String request){
        if(request != null){
            System.out.println(request);
            try {
                KeyStore keyStore = KeyStore.getInstance("JCEKS");
                InputStream stream =  SuitabilityTestController.class.getResourceAsStream("/00D0E0000000McO.jks");
                keyStore.load(stream, "Vector092016".toCharArray());
                Key key = keyStore.getKey("CertRequest", "Vector092016".toCharArray());
                Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
                cipher.init(Cipher.ENCRYPT_MODE, keyStore.getCertificate("CertRequest"));
                byte[] cipherText = cipher.doFinal(request.getBytes());
                System.out.println("cipher: " + new String(cipherText));
                return new ResponseEntity<String>(new String(cipherText),HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<String>("",getHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<String>(request,getHeaders(),HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/encryptAes", method=RequestMethod.POST)
    public ResponseEntity<String> encryptAes(@RequestBody String request, @RequestHeader("Date") String date){
        if(request != null){
            System.out.println(request);
            try {
                System.out.println("Original date:" + date);
                System.out.println("IVParam date:" + CryptoTools.getIvParameter(date));
                System.out.println("plain : " + CryptoTools.encryptWithAESKey(request,date));
                return new ResponseEntity<String>(CryptoTools.encryptWithAESKey(request,date),HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<String>("",getHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<String>(request,getHeaders(),HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value="/decryptTest", method=RequestMethod.POST)
    public ResponseEntity<String> decryptTest(@RequestBody String request, @RequestHeader("Date") String date){
        if(request != null){
            System.out.println(request);
            System.out.println(date);
            try {
                System.out.println("plain : " + CryptoTools.decryptWithAESKey(request,date));
                return new ResponseEntity<String>(CryptoTools.decryptWithAESKey(request,date),HttpStatus.OK);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<String>("",getHeaders(),HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<String>("",getHeaders(),HttpStatus.BAD_REQUEST);
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
        if("123456789".equals(id)){
            return true;
        }
        return false;
    }
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        //headers.add("Content-Type", "application/json");
        headers.add("Date","1997-01-31 09:26:50.120");
        return headers;
    }
}
