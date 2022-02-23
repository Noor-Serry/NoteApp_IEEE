package noor.serry.note;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
int timeSleep=3000;
 Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
      new Handler().postDelayed(new runneable(),timeSleep);

    }
    private class runneable implements Runnable{

        @Override
        public void run() {
goToMainActivity();
        }
        public void goToMainActivity(){
            intent =new Intent(getBaseContext(),MainActivity.class);
            startActivity(intent);
            finish();
        }}
}