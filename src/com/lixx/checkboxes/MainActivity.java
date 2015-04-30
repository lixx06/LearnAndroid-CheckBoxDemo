package com.lixx.checkboxes;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView textView;
	CheckBox eatBox,sleepBox,dotaBox,selectAllBox;
	int checkStatus = 0;	//store CheckBox status: from 0 to 7

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //add listener to CheckBox
        textView = (TextView)findViewById(R.id.textView);
        textView.setBackgroundColor(Color.BLUE);        
        eatBox = (CheckBox)findViewById(R.id.eatBox);
        eatBox.setOnCheckedChangeListener(new ClickListener());
        sleepBox = (CheckBox)findViewById(R.id.sleepBox);
        sleepBox.setOnCheckedChangeListener(new ClickListener());
        dotaBox = (CheckBox)findViewById(R.id.dotaBox);
        dotaBox.setOnCheckedChangeListener(new ClickListener());
        selectAllBox = (CheckBox)findViewById(R.id.selectAllBox);
        selectAllBox.setOnCheckedChangeListener(new ClickListener());        
    }
    
    private class ClickListener implements OnCheckedChangeListener{

		@Override
		public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
			// TODO Auto-generated method stub
			String tmpString = new String();
			if (arg0.getId() == R.id.eatBox){
				checkStatus += (arg1 ? 4 : -4);
				tmpString = ". EatBox " + (arg1 ? "Clicked" : "UnClicked");
			}
			else if(arg0.getId() == R.id.sleepBox){
				checkStatus += (arg1 ? 2 : -2);
				tmpString = ". SleepBox " + (arg1 ? "Clicked" : "UnClicked");
			}
			else if(arg0.getId() == R.id.dotaBox){
				checkStatus += (arg1 ? 1 : -1);
				tmpString = ". DotaBox " + (arg1 ? "Clicked" : "UnClicked");
			}
			else if(arg0.getId() == R.id.selectAllBox){				
				if(arg1){
					eatBox.setChecked(true);
					sleepBox.setChecked(true);
					dotaBox.setChecked(true);
				}
				else{
					eatBox.setChecked(false);
					sleepBox.setChecked(false);
					dotaBox.setChecked(false);
				}
				checkStatus = (arg1 ? 7 : 0);
				tmpString = ". SelectAllBox " + (arg1 ? "Clicked" : "UnClicked");
			}
			
			textView.setText("Status:" + checkStatus + tmpString);
			
		}
    	
    }
    
    /*
    private class ClickListener implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			if(arg0.getId() == R.id.eatBox)
			{	
				eatBox = (CheckBox)arg0;
				if (eatBox.isChecked()){
					checkStatus += 4;
					textView.setText("Status:" + checkStatus + ". EatBox Clicked!");
				}
				else{
					checkStatus -= 4;
					textView.setText("Status:" + checkStatus + ". EatBox UnClicked");					
				}				
			}
			else if(arg0.getId() == R.id.sleepBox){
				sleepBox = (CheckBox)arg0;
				if (sleepBox.isChecked()){
					checkStatus += 2;
					textView.setText("Status:" + checkStatus + ". SleepBox Clicked!");
				}
				else{
					checkStatus -= 2;
					textView.setText("Status:" + checkStatus + ". SleepBox UnClicked");					
				}				
			}
			else if(arg0.getId() == R.id.dotaBox){
				dotaBox = (CheckBox)arg0;
				if (dotaBox.isChecked()){
					checkStatus += 1;
					textView.setText("Status:" + checkStatus + ". DotaBox Clicked!");
				}
				else{
					checkStatus -= 1;
					textView.setText("Status:" + checkStatus + ". DotaBox UnClicked");					
				}
			}
			else if(arg0.getId() == R.id.selectAllBox){
				selectAllBox = (CheckBox)arg0;
				if (selectAllBox.isChecked()){
					checkStatus = 7;
					eatBox.setChecked(true);
					sleepBox.setChecked(true);
					dotaBox.setChecked(true);
					textView.setText("Status:" + checkStatus + ". SelectAllBox Clicked!");
				}
				else{
					eatBox.setChecked(false);
					sleepBox.setChecked(false);
					dotaBox.setChecked(false);
					checkStatus = 0;
					textView.setText("Status:" + checkStatus + ". SelectAllBox UnClicked");					
				}
			}
			
		}
    	
    }
*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
