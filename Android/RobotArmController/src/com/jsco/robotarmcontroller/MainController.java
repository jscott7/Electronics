package com.jsco.robotarmcontroller;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;

public class MainController extends Activity {
	
	private Button m_upButton;
	private Button m_downButton;
	private Button m_upButton2;
	private Button m_downButton2;
	private Button m_upButton3;
	private Button m_downButton3;

	private Button m_leftButton;
	private Button m_rightButton;
	private Button m_leftButtonGrip;
	private Button m_rightButtonGrip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_controller);
		
		WebView piWebView = (WebView)findViewById(R.id.webview);
		WebSettings webSettings = piWebView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		piWebView.setWebViewClient(new WebViewClient()
		{			
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) 
			{
				return false;
			}
		});
		
		piWebView.loadUrl("http://192.168.0.12:8082");
		
		// Get references to inflated widgets
		m_upButton = (Button) findViewById(R.id.up_button);	
		m_upButton.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				try
				{
					if (event.getAction() == MotionEvent.ACTION_DOWN)
					{
						new TcpClient().execute("o");
					}
					else if (event.getAction() == MotionEvent.ACTION_UP)
					{
						new TcpClient().execute(" ");
					}
				}
				catch(Exception ex)
				{
					return false;		
				}
				
				return true;
			}		
		});
				
		
		m_downButton = (Button) findViewById(R.id.down_button);
		m_downButton.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				try
				{
					if (event.getAction() == MotionEvent.ACTION_DOWN)
					{
						new TcpClient().execute("m");
					}
					else if (event.getAction() == MotionEvent.ACTION_UP)
					{
						new TcpClient().execute(" ");
					}
				}
				catch(Exception ex)
				{
					return false;
				}
				
				return true;
			}
			
		});	
		
		m_upButton2 = (Button) findViewById(R.id.up_button2);	
		m_upButton2.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				try
				{
					if (event.getAction() == MotionEvent.ACTION_DOWN)
					{
						new TcpClient().execute("e");
					}
					else if (event.getAction() == MotionEvent.ACTION_UP)
					{
						new TcpClient().execute(" ");
					}
				}
				catch(Exception ex)
				{
					return false;		
				}
				
				return true;
			}		
		});
				
		
		m_downButton2 = (Button) findViewById(R.id.down_button2);
		m_downButton2.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				try
				{
					if (event.getAction() == MotionEvent.ACTION_DOWN)
					{
						new TcpClient().execute("d");
					}
					else if (event.getAction() == MotionEvent.ACTION_UP)
					{
						new TcpClient().execute(" ");
					}
				}
				catch(Exception ex)
				{
					return false;
				}
				
				return true;
			}
			
		});		
		
		m_upButton3 = (Button) findViewById(R.id.up_button3);	
		m_upButton3.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				try
				{
					if (event.getAction() == MotionEvent.ACTION_DOWN)
					{
						new TcpClient().execute("t");
					}
					else if (event.getAction() == MotionEvent.ACTION_UP)
					{
						new TcpClient().execute(" ");
					}
				}
				catch(Exception ex)
				{
					return false;		
				}
				
				return true;
			}		
		});
				
		
		m_downButton3 = (Button) findViewById(R.id.down_button3);
		m_downButton3.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				try
				{
					if (event.getAction() == MotionEvent.ACTION_DOWN)
					{
						new TcpClient().execute("g");
					}
					else if (event.getAction() == MotionEvent.ACTION_UP)
					{
						new TcpClient().execute(" ");
					}
				}
				catch(Exception ex)
				{
					return false;
				}
				
				return true;
			}
			
		});		
		
		m_leftButton = (Button) findViewById(R.id.left_button);
		m_leftButton.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN)
				{
					new TcpClient().execute("l");
				}
				else if (event.getAction() == MotionEvent.ACTION_UP)
				{
					new TcpClient().execute(" ");
				}
				
				return true;
			}		
		});	
		
		m_rightButton = (Button) findViewById(R.id.right_button);
		m_rightButton.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN)
				{
					new TcpClient().execute("k");
				}
				else if (event.getAction() == MotionEvent.ACTION_UP)
				{
					new TcpClient().execute(" ");
				}
				
				return true;
			}		
		});	
		
		
		m_leftButtonGrip = (Button) findViewById(R.id.left_button_grip);
		m_leftButtonGrip.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN)
				{
					new TcpClient().execute("a");
				}
				else if (event.getAction() == MotionEvent.ACTION_UP)
				{
					new TcpClient().execute(" ");
				}
				
				return true;
			}		
		});	
		
		m_rightButtonGrip = (Button) findViewById(R.id.right_button_grip);
		m_rightButtonGrip.setOnTouchListener(new OnTouchListener(){

			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN)
				{
					new TcpClient().execute("s");
				}
				else if (event.getAction() == MotionEvent.ACTION_UP)
				{
					new TcpClient().execute(" ");
				}
				
				return true;
			}		
		});	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_controller, menu);
		return true;
	}

}
