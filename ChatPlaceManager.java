public class ChatPlaceManager {
    ChatPlace chatPlace = ChatPlace.idle;
    StateMachine stateMachine = new StateMachine();
    String textReceived;

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
                onCcySettingSaved();
                break;
        }

    }


    private void onSetSettingPressed() {
        System.out.println("onSetSettingPressed");
        setChatPlace(ChatPlace.onQtyAndBankAndCcyAndTime);

    }

    private void onCcySettingPressed() {
        System.out.println("onCcySettingPressed");
        setChatPlace(ChatPlace.onCurrencyChosen);


    }


    private void onCurrencyChosen(String text) {
        System.out.println("onCurrencyChosen");
        stateMachine.setCcy(text);
    }

    private void onCcySettingSaved(){
        stateMachine.save();
        setChatPlace(ChatPlace.onTimeSetting);
    }

}
