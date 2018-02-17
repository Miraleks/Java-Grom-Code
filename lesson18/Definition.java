package lesson18;

public class Definition {

    private void notifyUsers(String[] userEmails) {
        for (String email : userEmails) {

            try {
                //send email to user - error
                System.out.println("Email " + email + " was sent");
            } catch (Exception e) {
                //how should i handle exception
                System.out.println("Email " + email + " was not sent");
            } finally {

            }
//            } catch (Exception e1) {
//
//            }
        }
//        1
//        2
//        3

    }
}
