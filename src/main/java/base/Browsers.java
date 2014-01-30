package base;

/**
 * Created with IntelliJ IDEA.
 * User: okunev
 * Date: 1/30/14
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */

    public enum Browsers {

        FIREFOX,
        CHROME,
        IEXPLORER,
        SAFARI;



    public static Browsers browserForName(String browser) throws IllegalArgumentException{
        for(Browsers b: values()){
            if(b.toString().equalsIgnoreCase(browser)){
                return b;
            }
        }
        throw browserNotFound(browser);
    }

    private static IllegalArgumentException browserNotFound(String outcome) {
        return new IllegalArgumentException(("Invalid browser [" + outcome + "]"));
    }

    }