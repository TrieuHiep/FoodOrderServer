/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bean.AccountFacadeLocal;
import entities.Account;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author tatsuya
 */
@WebService(serviceName = "accountws")
@Stateless()
public class accountws {

    @EJB
    private AccountFacadeLocal accountFacade;

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

//    @WebMethod(operationName = "addAccountByString")
//    public Boolean addAccountByString(@WebParam(name = "username") String username,
//            @WebParam(name = "password") String password) {
//        Account account = new Account();
//        account.setUsername(username);
//        account.setPassword(password);
//        accountFacade.create(account);
//        return true;
//    }
//
//    @WebMethod(operationName = "addAccountByObject")
//    public Boolean addAccountByObject(@WebParam(name = "account") Account account) {
//        accountFacade.create(account);
//        return true;
//    }
//
//    @WebMethod(operationName = "getAllAccount")
//    public List<Account> getAllAccount() {
//        return accountFacade.findAll();
//    }

    @WebMethod(operationName = "validateAccount")
    public Boolean validateAccount(@WebParam(name = "account") Account account) {
        Account result = accountFacade.find(account.getUsername());
        if (result != null) {
            System.out.println(result);
            return true;
        } else {
            System.out.println("deo tim thay");
            return false;
        }
    }

}
