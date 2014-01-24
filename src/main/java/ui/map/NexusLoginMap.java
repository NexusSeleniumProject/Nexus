package ui.map;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/15/14
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class NexusLoginMap {
    public enum LoginPage {
        //Login Screen
        INP_USERNAME("//input[@id='email']"),
        INP_PASSWORD("//input[@name='password']"),
        BTN_LOGIN("//button[@name='button']"),
        ;

        String id;

        private LoginPage(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }
}
