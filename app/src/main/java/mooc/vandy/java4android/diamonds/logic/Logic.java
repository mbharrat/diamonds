package mooc.vandy.java4android.diamonds.logic;

import android.util.Log;
import mooc.vandy.java4android.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) {

        int count = 0;
        Boolean check = false;
        Boolean mid = false;
        for(int i =0; i<2*size+1;i++){
            check = false;
            for(int j = 0; j<2*size+2;j++){
                //frame check
                if(i == 0 || i == 2*size){//create frame
                    if(j==0 || j==2*size+1){
                        mOut.print("+");

                    }else{
                        mOut.print("-");
                    }
                }else if(j==0 ||j==2*size+1){
                    mOut.print("|");
                    count++;
                }else if(mid == false && i!=size){
                    int r = size - i;//algo for checking where to start
                    r = r+1;
                    if(j == r){
                        mOut.print("/");
                        count++;
                        check = true;
                    }
                    int q = (r+(2*i-2));
                    if(j == q){
                        mOut.print("\\");
                        count++;
                        check = false;
                    }else{
                        if(check == true){
                            if(i%2==0){
                                mOut.print("-");
                                count++;
                            }else{
                                mOut.print("=");
                                count++;
                            }
                        }else{
                            if(count<2*size+1){
                                mOut.print(" ");
                                count++;
                            }
                        }
                    }
                }else if(i==size){
                    mid = true;
                    if(j==1){
                        mOut.print("<");
                    }else if(j==2*size){
                        mOut.print(">");
                    }else{
                        if(i%2==0){
                            mOut.print("-");
                        }else{
                            mOut.print("=");
                        }
                    }
                }else if(mid == true){
                    int g = i - size;
                    int y = size - g;
                    int r = size - y;
                    r = r+1;
                    if(j == r){
                        mOut.print("\\");
                        count++;
                        check = true;
                    }
                    int q = (r+(2*y-2));
                    if(j == q){
                        mOut.print("/");
                        count++;
                        check = false;
                    }else{
                        if(check == true){
                            if(i%2==0){
                                mOut.print("-");
                                count++;
                            }else{
                                mOut.print("=");
                                count++;
                            }
                        }else{
                            if(count<2*size+1){
                                mOut.print(" ");
                                count++;
                            }
                        }
                    }
                }
            }
            mOut.print("\n");
            count = 0;
        }


    }
   
}
