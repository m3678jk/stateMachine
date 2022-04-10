import lombok.Data;

import java.sql.Time;

public class StateMachine {

    private ChatSettings chatSettings = new ChatSettings();

    public void setQtyOfSignAfterPoint(String text) {
        chatSettings.setQuantityOfSignsAfterDot(Integer.parseInt(text));
    }

    public void setBank(String name) {
        chatSettings.setBank(name);
    }

    public void setNotificationTime(String text) {
        if (text.equals("Notification off")) {
            chatSettings.setDoNotify(false);
        } else {
            chatSettings.setNotifyTime(new Time(Integer.parseInt(text), 0, 0));
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
    public String getInfo(){
        String result = "";
        //TODO there should be method which provide info from CurrencyServices based oh setting
        //
        return result;
    }
    void save() {
        System.out.println("data is saved");

        System.out.println("stateMachine.toString() = " + toString());
        //
        // should be saved in Map with <ChatId, StateMachine>

        // then separately using stateMachine setting look up for needed info in currency service
    }

    @Override
    public String toString() {
        return "StateMachine{" +
                "chatSettings=" + chatSettings +
                '}';
    }
}
@Data
class ChatSettings {

    private boolean isUsdNeed;
    private boolean isEurNeed;
    private String bank;
    private int quantityOfSignsAfterDot;
    private boolean doNotify;
    private Time notifyTime;

    //default data
    public ChatSettings() {
        this.isUsdNeed = true;
        this.isEurNeed = false;
        this.bank = "NBU";
        this.quantityOfSignsAfterDot = 2;
        this.doNotify = true;
        //cannot find alternative
        this.notifyTime = new Time(11, 0, 0);
    }

    @Override
    public String toString() {
        return "ChatSettings{" +
                "isUsdNeed=" + isUsdNeed +
                ", isEurNeed=" + isEurNeed +
                ", bank='" + bank + '\'' +
                ", quantityOfSignsAfterDot=" + quantityOfSignsAfterDot +
                ", doNotify=" + doNotify +
                ", notifyTime=" + notifyTime +
                '}';
    }
}


