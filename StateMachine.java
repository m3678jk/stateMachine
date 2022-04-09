//import java.time.Clock;

public class StateMachine {

    private ChatSettings chatSettings;
    //onCcySetting
    {
        chatSettings = new ChatSettings();
    }

    public void setCcy(String text) {
        //if pressed button "USD" and this setting was not active before, then switch on this function
        // or other way around
        if (text.equals("USD") && !chatSettings.isUsdNeed()) {
            chatSettings.setUsdNeed(true);
            System.out.println("USD on");
        } else if (text.equals("USD") && chatSettings.isUsdNeed()) {
            chatSettings.setUsdNeed(false);
            System.out.println("USD off");

        }
        //if pressed button "EUR"and this setting was not active before, then switch on this function.
        //or other way around

        if (text.equals("EUR") && !chatSettings.isEurNeed()) {
            chatSettings.setEurNeed(true);
            System.out.println("EUR on");

        } else if (text.equals("EUR") && chatSettings.isEurNeed()) {
            chatSettings.setEurNeed(false);
            System.out.println("EUR off");

        }

    }
    void save (){
        System.out.println("data is saved - method should be done");
    }


}

class ChatSettings {

    //boolean isCurrencyNeeded;
    //List<Boolean> bankNeeded;
    private boolean isUsdNeed;
    private boolean isEurNeed;

//    int quantityOfSignsAfterDot;
//    boolean doNotify;
//    Clock notifyTime;

    public boolean isUsdNeed() {
        return isUsdNeed;
    }

    public void setUsdNeed(boolean usdNeed) {
        isUsdNeed = usdNeed;
    }

    public boolean isEurNeed() {
        return isEurNeed;
    }

    public void setEurNeed(boolean eurNeed) {
        isEurNeed = eurNeed;
    }
    //Public stateMachine.ChatSettings() пробігаючи по лісту валют, лісту банків
    //ініціює currencyNeeded, bankNeeded
}


