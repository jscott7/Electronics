// Listen to bytes on serial port and drive motor shield accordingly
// This is for newer style motorshield

byte inByte;

void setup() {
   // initialise serial comms at 9600 baud
   Serial.begin(9600);
   
   // Commented out lines for debugging using the on-board LED
   // pinMode(13,OUTPUT);
   // digitalWrite(13, LOW);
   
    //Setup Channel A
   pinMode(12, OUTPUT);    // Initialise Motor Channel A pin - DIRECTION
   pinMode(9, OUTPUT);     // Initialise Brake Channel A pin - BRAKE

   //Setup Channel B
   pinMode(13, OUTPUT);    // Initialise Motor Channel A pin - DIRECTION
   pinMode(8, OUTPUT);     // Initialise Brake Channel A pin - BRAKE
   
   Serial.println("Started");
}

void loop() {
 
  while (Serial.available() > 0)
  {
    inByte = Serial.read();
      
    if (inByte > 0)
    {
       Serial.println(inByte);
    }
     
    if (inByte == 108) // 'l' 
    { 
       digitalWrite(12, HIGH);  // Establish forward direction of Channel A
       digitalWrite(9, LOW);    // Disengage the break for Channel A
       digitalWrite(8, HIGH);   // Engage the Brake for Channel B
       analogWrite(3,244);      // Spin the motor on Channel A at full speed
    }
    if (inByte == 107) // 'k'
    {  
      digitalWrite(12, LOW);    // Establishes backward direction of Channel A
      digitalWrite(9, LOW);     // Disengage the Brake for Channel A
      digitalWrite(8, HIGH);    // Engage the Brake for Channel B
      analogWrite(3, 244);      // Spin the motor on Channel A at half speed
    } 
    if (inByte == 111) //'o'
    {
      // digitalWrite(13,HIGH);
      digitalWrite(13, HIGH);  // Establish forward direction of Channel B
      digitalWrite(8, LOW);    // Disengage the break for Channel B
      digitalWrite(9, HIGH);   // Engage the Brake for Channel A
      analogWrite(11,244);     // Spin the motor on Channel B at full speed    
    }     
    if (inByte == 109 ) //'m'
    {
      // digitalWrite(13,LOW);
      digitalWrite(13, LOW);    // Establishes backward direction of Channel B
      digitalWrite(8, LOW);     // Disengage the Brake for Channel B
      digitalWrite(9, HIGH);    // Engage the Brake for Channel A
      analogWrite(11, 244);     // Spins the motor on Channel B at half speed 
    }
     
    if (inByte == 32) //' '
    {
      digitalWrite(8, HIGH);    // Engage the Brake for Channel B
      digitalWrite(9, HIGH);    // Engage the Brake for Channel A   
    }
  } 
}


