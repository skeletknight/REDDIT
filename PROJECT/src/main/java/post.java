import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class post {

    String title_of_post;
    String text_of_post;
    String community_name;
    String username;
    int vote = 0;
    ArrayList <comment> Comment_of_Post = new ArrayList<comment>();
    Scanner scanner= new Scanner(System.in);


    public void showing_post(){//do they need a post object?

        System.out.println(community_name + "\n");
        System.out.println("op: "+username + "\n");//username gave it in another function
        System.out.println(title_of_post+"\n");
        System.out.println(text_of_post + "\n");
        System.out.println(vote+ "\n\n" + "comment section: ");



        if(Comment_of_Post.isEmpty()) {
            System.out.println("there is no comment yet comeback later");
        }
        else{
            int count = 0;
            comment comment1;
            for (comment comment : Comment_of_Post) {
                comment.show_comment();
                count++;
            }
            System.out.println("please select the comment that you like to vote");
            int chose = scanner.nextInt();
            comment1 = Comment_of_Post.get(chose);
            System.out.println("do you want to increase it or decrease it? + for increase and - for decrease");
            String input = scanner.next();
            if(input=="+"){
                comment1.vote++;
            }
            else{
                comment1.vote--;
            }
        }

    }
    public void vote (User user,post post){
        System.out.println(vote);
        System.out.println("enter + to increase the votes enter - to decrease the votes");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        if(Objects.equals(input, "+")){
            vote++;
            user.karma++;
        }
        if(Objects.equals(input, "-")){
            vote--;
            user.karma--;
        }

    }




}
