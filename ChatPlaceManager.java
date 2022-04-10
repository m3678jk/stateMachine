import java.util.HashMap;
import java.util.Map;

public class ChatPlaceManager {
    private ChatPlace chatPlace = ChatPlace.idle;
    private StateMachine stateMachine = new StateMachine();

//     private Map<String, StateMachine> stateMachineMap = new HashMap<>();

//     public Map<String, StateMachine> getStateMachineMap() {
//         return stateMachineMap;
//     }

    void setChatPlace(ChatPlace newChatPlace) {
        this.chatPlace = newChatPlace;

    }

    public void handle(String text) {
        switch (text) {
            case "Ccy setting":
                onCcySettingPressed();
                break;

            case "USD":
            case "EUR":
                onCurrencyChosen(text);
                break;

            case "Set setting":
                onSetSettingPressed();
                break;
            case "Ok":
                onAnySettingSaved();
                break;

            case "Set time":
                onTimeSettingPressed();
                break;

            case "12":
            case "13":
                onTimeChosen(text );
                break;

            case "Set qty":
                onQtySignAfterDot(text);
                break;
            case "1":
            case "2":
                onQtySignAfterDotChosen(Integer.parseInt(text));
                break;

            case "Bank setting":
                onBankSetting();
                break;

            case "NBU":
            case "Privat":
            case "Mono":

                onBankChosen(text);
                break;

        }

    }


    private void onSetSettingPressed() {
        System.out.println("onSetSettingPressed");
        setChatPlace(ChatPlace.settingPressed);

    }

    private void onCcySettingPressed() {
        System.out.println("onCcySettingPressed");
        setChatPlace(ChatPlace.waitForCurrency);


    }


    private void onCurrencyChosen(String text) {
        System.out.println("onCurrencyChosen");
        stateMachine.setCcy(text);
    }

    private void onAnySettingSaved() {
        stateMachine.save();
        setChatPlace(ChatPlace.settingPressed);
    }

    private void onTimeSettingPressed() {
        System.out.println("onTimeSettingPressed");
        setChatPlace(ChatPlace.waitForTime);
    }

    private void onTimeChosen(String text) {
        System.out.println("onTimeChosen");
        stateMachine.setNotificationTime(text);
    }

    private void onQtySignAfterDot(String text) {
        System.out.println("onQtySignAfterDot");
        setChatPlace(ChatPlace.waitForQty);
    }

    private void onQtySignAfterDotChosen(int number){
        System.out.println("onQtySignAfterDotChosen");
        stateMachine.setQtyOfSignAfterPoint(number);
    }

   private void onBankSetting(){
       System.out.println("onBankSetting");
       setChatPlace(ChatPlace.waitForBank);
   }

   private void onBankChosen(String text){
       System.out.println("onBankChosen");
       stateMachine.setBank(text);
   }


}
