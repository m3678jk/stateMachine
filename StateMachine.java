package stateMachine;

import org.checkerframework.checker.units.qual.C;

import java.sql.Time;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;

public class StateMachine {

    private ChatSettings chatSettings;

//    private List <StateMachineListener> listeners = new ArrayList<>();
//
//    void addListener(StateMachineListener stateMachineListener){
//        listeners.add(stateMachineListener);
//    }

    {
        chatSettings = new ChatSettings();
    }

    public void setQtyOfSignAfterPoint(int number) {
        chatSettings.setQuantityOfSignsAfterDot(number);
    }

    public void setBank(String name) {
        chatSettings.setBank(name);
    }

    public void setNotificationTime(String text) {
        if (text.equals("Notification off")) {
            chatSettings.setDoNotify(false);
        } else {
            chatSettings.setNotifyTime(new Time(Integer.parseInt(text)));
        }

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

    void save() {
        System.out.println("data is saved - method should be done");
        //TODO
    }


}

class ChatSettings {

    private boolean isUsdNeed;
    private boolean isEurNeed;
    private String bank;
    private int quantityOfSignsAfterDot;
    private boolean doNotify;
    private Time notifyTime;

    public int getQuantityOfSignsAfterDot() {
        return quantityOfSignsAfterDot;
    }

    public void setQuantityOfSignsAfterDot(int quantityOfSignsAfterDot) {
        this.quantityOfSignsAfterDot = quantityOfSignsAfterDot;
    }


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

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBank() {
        return bank;
    }

    public void setDoNotify(boolean doNotify) {
        this.doNotify = doNotify;
    }

    public boolean isDoNotify() {
        return doNotify;
    }

    public void setNotifyTime(Time notifyTime) {
        this.notifyTime = notifyTime;
    }
    
    public Time getNotifyTime() {
        return notifyTime;
    }

    //   it maybe will be needed for creating default settings, but for now it just disturbs to use above methods
//    public ChatSettings(boolean isUsdNeed, boolean isEurNeed, String bank, int quantityOfSignsAfterDot, boolean doNotify, Clock notifyTime) {
//        this.isUsdNeed = isUsdNeed;
//        this.isEurNeed = isEurNeed;
//        this.bank = bank;
//        this.quantityOfSignsAfterDot = quantityOfSignsAfterDot;
//        this.doNotify = doNotify;
//        this.notifyTime = notifyTime;
//    }
    
}


