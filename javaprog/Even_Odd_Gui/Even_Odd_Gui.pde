 import controlP5.*;
 ControlP5 controlP5;
 Textfield myTextfield;
 int box_width=100;
 StartGame g;
void setup(){
   
  size(500,500);
  background(255);
  frameRate(30);
g = new StartGame();
  g.start();
  g.menu();
  controlP5 = new ControlP5(this);
   myTextfield = controlP5.addTextfield("texting",width/2-box_width/2,height-50,box_width,20);
}

void draw(){
  

}



