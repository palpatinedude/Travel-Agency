public class Main {
    public static void main(String[] args) {
        LoginForm loginForm=new LoginForm(null);
        User user=LoginForm.user;
        if(user!=null){
            System.out.println("Successful Authentication!\nUser AT:"+user.username);
            InsertPanel insertPanel=new InsertPanel(null);
            insertPanel.show();


        }else{
            System.out.println("Authentication Canceled");
        }
    }
}
