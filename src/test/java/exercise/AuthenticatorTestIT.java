
package exercise;

import static org.mockito.Mockito.mock;
import exercise.realdatabase.UserFacadeRealDB;
import Utils.Mailer;

public class AuthenticatorTestIT extends AuthenticatorTest{
 
    @Override
    public Authenticator makeAuthenticator(){
        Mailer mailer = mock(Mailer.class);
        
        if(System.getenv("TRAVIS") != null){
            return new Authenticator(new UserFacadeRealDB("pu_mySql_travis_Integration"), mailer);
            
        }else {
            return new Authenticator(new UserFacadeRealDB("pu_localDB"), mailer);
        }
    }
}
