import java.io.*;
import com.leapmotion.leap.*;
import com.leapmotion.leap.Finger.Type;
import com.leapmotion.leap.Frame;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

class panel extends JFrame {
    private final char[] JA = {0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 
             0x3142, 0x3143, 0x3145, 0x3146, 0x3147, 0x3148, 
             0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e};
//ㅏㅐㅑㅒㅓㅔㅕㅖ ㅗ ㅘ ㅙ ㅚ ㅛ ㅜ ㅝ ㅞ ㅟ ㅠ ㅡ ㅢ ㅣ
    private final char[] MO = {0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 
             0x3156, 0x3157, 0x3158, 0x3159, 0x315a, 0x315b, 
             0x315c, 0x315d, 0x315e, 0x315f, 0x3160, 0x3161,    
             0x3162, 0x3163};
//ㄱㄲㄳㄴㄵㄶㄷㄹㄺ ㄻ ㄼ ㄽ ㄾ ㄿ ㅀ ㅁ ㅂ ㅄ ㅅ ㅆ ㅇ ㅈ ㅊ ㅋ ㅌ ㅍ ㅎ
    private final char[] JONG = {0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 
             0x3137, 0x3139, 0x313a, 0x313b, 0x313c, 0x313d, 
             0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 
             0x3145, 0x3146, 0x3147, 0x3148, 0x314a, 0x314b, 
             0x314c, 0x314d, 0x314e};
    public String cho_[]=new  String[15];
    public String tempStr ;
    int j=0;
    int k=0;
    int q=0;
    
    ImageIcon a1=new ImageIcon("images/ㄱ.jpg");//버튼 만들기
    Image a1_ = a1.getImage(); 
    Image a1__ = a1_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a1___ = new ImageIcon(a1__); //Image로 ImageIcon 생성
    
    ImageIcon a2=new ImageIcon("images/ㄴ.jpg");
    Image a2_ = a2.getImage(); 
    Image a2__ = a2_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a2___ = new ImageIcon(a2__); //Image로 ImageIcon 생성    
    
    ImageIcon a3=new ImageIcon("images/ㄷ.jpg");
    Image a3_ = a3.getImage(); 
    Image a3__ = a3_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a3___ = new ImageIcon(a3__); //Image로 ImageIcon 생성
    
    ImageIcon a4=new ImageIcon("images/ㄹ.jpg");
    Image a4_ = a4.getImage(); 
    Image a4__ = a4_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a4___ = new ImageIcon(a4__); //Image로 ImageIcon 생성
   
    ImageIcon a5=new ImageIcon("images/ㅁ.jpg");
    Image a5_ = a5.getImage(); 
    Image a5__ = a5_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a5___ = new ImageIcon(a5__); //Image로 ImageIcon 생성
 
    ImageIcon a6=new ImageIcon("images/ㅂ.jpg");
    Image a6_ = a6.getImage(); 
    Image a6__ = a6_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a6___ = new ImageIcon(a6__); //Image로 ImageIcon 생성
    
    ImageIcon a7=new ImageIcon("images/ㅅ.jpg");
    Image a7_ = a7.getImage(); 
    Image a7__ = a7_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a7___ = new ImageIcon(a7__); //Image로 ImageIcon 생성

    ImageIcon a8=new ImageIcon("images/ㅇ.jpg");
    Image a8_ = a8.getImage(); 
    Image a8__ = a8_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a8___ = new ImageIcon(a8__); //Image로 ImageIcon 생성   
    
    ImageIcon a9=new ImageIcon("images/ㅈ.jpg");
    Image a9_ = a9.getImage(); 
    Image a9__ = a9_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a9___ = new ImageIcon(a9__); //Image로 ImageIcon 생성 
    
    ImageIcon a10=new ImageIcon("images/ㅊ.jpg");
    Image a10_ = a10.getImage(); 
    Image a10__ = a10_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a10___ = new ImageIcon(a10__); //Image로 ImageIcon 생성
  
    ImageIcon a11=new ImageIcon("images/ㅋ.jpg");
    Image a11_ = a11.getImage(); 
    Image a11__ = a11_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a11___ = new ImageIcon(a11__); //Image로 ImageIcon 생성    
    
    ImageIcon a12=new ImageIcon("images/ㅌ.jpg");
    Image a12_ = a12.getImage(); 
    Image a12__ = a12_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a12___ = new ImageIcon(a12__); //Image로 ImageIcon 생성
 
    ImageIcon a13=new ImageIcon("images/ㅍ.jpg");
    Image a13_ = a13.getImage(); 
    Image a13__ = a13_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a13___ = new ImageIcon(a13__); //Image로 ImageIcon 생성
  
    ImageIcon a14=new ImageIcon("images/ㅎ.jpg");
    Image a14_ = a14.getImage(); 
    Image a14__ = a14_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a14___ = new ImageIcon(a14__); //Image로 ImageIcon 생성

    ImageIcon a15=new ImageIcon("images/ㅏ.jpg");
    Image a15_ = a15.getImage(); 
    Image a15__ = a15_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a15___ = new ImageIcon(a15__); //Image로 ImageIcon 생성

    ImageIcon a16=new ImageIcon("images/ㅑ.jpg");
    Image a16_ = a16.getImage(); 
    Image a16__ = a16_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a16___ = new ImageIcon(a16__); //Image로 ImageIcon 생성
    
    ImageIcon a17=new ImageIcon("images/ㅓ.jpg");
    Image a17_ = a17.getImage(); 
    Image a17__ = a17_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a17___ = new ImageIcon(a17__); //Image로 ImageIcon 생성

    ImageIcon a18=new ImageIcon("images/ㅕ.jpg");
    Image a18_ = a18.getImage(); 
    Image a18__ = a18_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a18___ = new ImageIcon(a18__); //Image로 ImageIcon 생성
    
    ImageIcon a19=new ImageIcon("images/ㅗ.jpg");
    Image a19_ = a19.getImage(); 
    Image a19__ = a19_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a19___ = new ImageIcon(a19__); //Image로 ImageIcon 생성 
    
    ImageIcon a20=new ImageIcon("images/ㅛ.jpg");
    Image a20_ = a20.getImage(); 
    Image a20__ = a20_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a20___ = new ImageIcon(a20__); //Image로 ImageIcon 생성

    ImageIcon a21=new ImageIcon("images/ㅜ.jpg");
    Image a21_ = a21.getImage(); 
    Image a21__ = a21_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a21___ = new ImageIcon(a21__); //Image로 ImageIcon 생성  
    
    ImageIcon a22=new ImageIcon("images/ㅠ.jpg");
    Image a22_ = a22.getImage(); 
    Image a22__ = a22_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a22___ = new ImageIcon(a22__); //Image로 ImageIcon 생성

    ImageIcon a23=new ImageIcon("images/ㅡ.jpg");
    Image a23_ = a23.getImage(); 
    Image a23__ = a23_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a23___ = new ImageIcon(a23__); //Image로 ImageIcon 생성

    ImageIcon a24=new ImageIcon("images/ㅣ.jpg");
    Image a24_ = a24.getImage(); 
    Image a24__ = a24_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a24___ = new ImageIcon(a24__); //Image로 ImageIcon 생성
    
    ImageIcon a25=new ImageIcon("images/ㅐ.jpg");
    Image a25_ = a25.getImage(); 
    Image a25__ = a25_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a25___ = new ImageIcon(a25__); //Image로 ImageIcon 생성
  
    ImageIcon a26=new ImageIcon("images/ㅒ.jpg");
    Image a26_ = a26.getImage(); 
    Image a26__ = a26_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a26___ = new ImageIcon(a26__); //Image로 ImageIcon 생성

    ImageIcon a27=new ImageIcon("images/ㅔ.jpg");
    Image a27_ = a27.getImage(); 
    Image a27__ = a27_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a27___ = new ImageIcon(a27__); //Image로 ImageIcon 생성

    ImageIcon a28=new ImageIcon("images/ㅖ.jpg");
    Image a28_ = a28.getImage(); 
    Image a28__ = a28_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a28___ = new ImageIcon(a28__); //Image로 ImageIcon 생성
    
    ImageIcon a29=new ImageIcon("images/ㅢ.jpg");
    Image a29_ = a29.getImage(); 
    Image a29__ = a29_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a29___ = new ImageIcon(a29__); //Image로 ImageIcon 생성

    ImageIcon a30=new ImageIcon("images/ㅚ.jpg");
    Image a30_ = a30.getImage(); 
    Image a30__ = a30_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a30___ = new ImageIcon(a30__); //Image로 ImageIcon 생성

    ImageIcon a31=new ImageIcon("images/ㅟ.jpg");
    Image a31_ = a31.getImage(); 
    Image a31__ = a31_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    ImageIcon a31___ = new ImageIcon(a31__);
    
    ImageIcon a32=new ImageIcon("images/옴팡옴팡.jpg");
    Image a32_ = a32.getImage(); 
    Image a32__ = a32_.getScaledInstance(182, 108, java.awt.Image.SCALE_SMOOTH);
    
    ImageIcon h1=new ImageIcon("images/현수ㄱ.jpg");//버튼 만들기
    Image h1_ = h1.getImage(); 
    
    ImageIcon h2=new ImageIcon("images/현수ㄴ.jpg");//버튼 만들기
    Image h2_ = h2.getImage();
    
    ImageIcon h3=new ImageIcon("images/현수ㄷ.jpg");//버튼 만들기
    Image h3_ = h3.getImage();
    
    ImageIcon h4=new ImageIcon("images/현수ㄹ.jpg");//버튼 만들기
    Image h4_ = h4.getImage();
    
    ImageIcon h5=new ImageIcon("images/현수ㅁ.jpg");//버튼 만들기
    Image h5_ = h5.getImage();
    
    ImageIcon h6=new ImageIcon("images/현수ㅂ.jpg");//버튼 만들기
    Image h6_ = h6.getImage();
    
    ImageIcon h7=new ImageIcon("images/현수ㅅ.jpg");//버튼 만들기
    Image h7_ = h7.getImage();
    
    ImageIcon h8=new ImageIcon("images/현수ㅇ.jpg");//버튼 만들기
    Image h8_ = h8.getImage();
    
    ImageIcon h9=new ImageIcon("images/현수ㅈ.jpg");//버튼 만들기
    Image h9_ = h9.getImage();
    
    ImageIcon h10=new ImageIcon("images/현수ㅊ.jpg");//버튼 만들기
    Image h10_ = h10.getImage();
    
    ImageIcon h11=new ImageIcon("images/현수ㅋ.jpg");//버튼 만들기
    Image h11_ = h11.getImage();
    
    ImageIcon h12=new ImageIcon("images/현수ㅌ.jpg");//버튼 만들기
    Image h12_ = h12.getImage();
    
    ImageIcon h13=new ImageIcon("images/현수ㅍ.jpg");//버튼 만들기
    Image h13_ = h13.getImage();
    
    ImageIcon h14=new ImageIcon("images/현수ㅎ.jpg");//버튼 만들기
    Image h14_ = h14.getImage();
    
    ImageIcon h15=new ImageIcon("images/현수ㅏ.jpg");//버튼 만들기
    Image h15_ = h15.getImage();
    
    ImageIcon h16=new ImageIcon("images/현수ㅑ.jpg");//버튼 만들기
    Image h16_ = h16.getImage();
    
    ImageIcon h17=new ImageIcon("images/현수ㅓ.jpg");//버튼 만들기
    Image h17_ = h17.getImage();
    
    ImageIcon h18=new ImageIcon("images/현수ㅕ.jpg");//버튼 만들기
    Image h18_ = h18.getImage();
    
    ImageIcon h19=new ImageIcon("images/현수ㅗ.jpg");//버튼 만들기
    Image h19_ = h19.getImage();
    
    ImageIcon h20=new ImageIcon("images/현수ㅛ.jpg");//버튼 만들기
    Image h20_ = h20.getImage();
    
    ImageIcon h21=new ImageIcon("images/현수ㅜ.jpg");//버튼 만들기
    Image h21_ = h21.getImage();
    
    ImageIcon h22=new ImageIcon("images/현수ㅠ.jpg");//버튼 만들기
    Image h22_ = h22.getImage();
    
    ImageIcon h23=new ImageIcon("images/현수ㅡ.jpg");//버튼 만들기
    Image h23_ = h23.getImage();
    
    ImageIcon h24=new ImageIcon("images/현수ㅣ.jpg");//버튼 만들기
    Image h24_ = h24.getImage();
    
    ImageIcon h25=new ImageIcon("images/현수ㅐ.jpg");//버튼 만들기
    Image h25_ = h25.getImage();
    
    ImageIcon h26=new ImageIcon("images/현수ㅒ.jpg");//버튼 만들기
    Image h26_ = h26.getImage();
    
    ImageIcon h27=new ImageIcon("images/현수ㅔ.jpg");//버튼 만들기
    Image h27_ = h27.getImage();
    
    ImageIcon h28=new ImageIcon("images/현수ㅖ.jpg");//버튼 만들기
    Image h28_ = h28.getImage();
    
    ImageIcon h29=new ImageIcon("images/현수ㅢ.jpg");//버튼 만들기
    Image h29_ = h29.getImage();
    
    ImageIcon h30=new ImageIcon("images/현수ㅚ.jpg");//버튼 만들기
    Image h30_ = h30.getImage();
    
    ImageIcon h31=new ImageIcon("images/현수ㅟ.jpg");//버튼 만들기
    Image h31_ = h31.getImage();
    
    public JButton btn1,btn2,btn3,btn4,btn5,
    btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn13,btn14,btn15,
    btn16,btn17,btn18,btn19,btn20,btn21,btn22,btn23,btn24,btn25,
    btn26,btn27,btn28,btn29,btn30,btn31;
    
    public String rece;
    
    JPanel pa1 = new finger();
    JPanel pa5 = new pa5_();
    JPanel pa3 = new pa3_();
    JPanel pa6 = new pa6_();
    
    public Vector PalmPosition, THUMB_1, THUMB_2, THUMB_3,
                INDEX_1, INDEX_2, INDEX_3, INDEX_4,
                MIDDLE_1, MIDDLE_2, MIDDLE_3, MIDDLE_4,
                RING_1, RING_2, RING_3, RING_4,
                PINKY_1, PINKY_2, PINKY_3, PINKY_4;
    
    public void PalmPosition(Vector n) {PalmPosition=n;pa1.repaint();}
    public void THUMB_1(Vector n) {THUMB_1=n;pa1.repaint();}
    public void THUMB_2(Vector n) {THUMB_2=n;pa1.repaint();}
    public void THUMB_3(Vector n) {THUMB_3=n;pa1.repaint();}
    public void INDEX_1(Vector n) {INDEX_1=n;pa1.repaint();}
    public void INDEX_2(Vector n) {INDEX_2=n;pa1.repaint();}
    public void INDEX_3(Vector n) {INDEX_3=n;pa1.repaint();}
    public void INDEX_4(Vector n) {INDEX_4=n;pa1.repaint();}
    public void MIDDLE_1(Vector n) {MIDDLE_1=n;pa1.repaint();}
    public void MIDDLE_2(Vector n) {MIDDLE_2=n;pa1.repaint();}
    public void MIDDLE_3(Vector n) {MIDDLE_3=n;pa1.repaint();}
    public void MIDDLE_4(Vector n) {MIDDLE_4=n;pa1.repaint();}
    public void RING_1(Vector n) {RING_1=n;pa1.repaint();}
    public void RING_2(Vector n) {RING_2=n;pa1.repaint();}
    public void RING_3(Vector n) {RING_3=n;pa1.repaint();}
    public void RING_4(Vector n) {RING_4=n;pa1.repaint();}
    public void PINKY_1(Vector n) {PINKY_1=n;pa1.repaint();}
    public void PINKY_2(Vector n) {PINKY_2=n;pa1.repaint();}
    public void PINKY_3(Vector n) {PINKY_3=n;pa1.repaint();}
    public void PINKY_4(Vector n) {PINKY_4=n;pa1.repaint();}    

    public void rece(String s) { 
        rece=s;
        pa6.repaint();
           if(cho_[j]!=null) {
             Color background = new Color(255,242,230);
              pa5.setBackground(background);
              if(cho_[j].equals(s)) {
                 q++; 
                 if(q>5) { 
                    j++; 
                    pa5.setBackground(Color.GREEN);
                    if (cho_[j]!=null) {
                    pa5.repaint();
                    q=0;
                  }
                }
              }
            }
          }

 panel(){
    setTitle("지화 학습기");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = getContentPane();
    c.setLayout(null);
    Color background = new Color(255,242,230);
    pa1 = new finger();   
    pa1.setBounds(0,0,646,490);
    pa1.setBackground(background);
    pa1.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
    
    JPanel pa2 = new JPanel();
    pa2.setLayout(new GridLayout(5,7));
    pa2.setBounds(646,0,1274,540);
    pa2.setBackground(background);
    pa2.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
    
    pa3 = new pa3_();
    pa3.setBounds(0,540,960,180);
    pa3.setBackground(background);
    pa3.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
    
    JPanel pa4 = new JPanel();
    pa4.setLayout(null);
    pa4.setBounds(0,720,960,340);
    pa4.setBackground(background);
    pa4.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));

    pa5= new pa5_();
    pa5.setBounds(960,540,960,520);
    pa5.setBackground(background);
    pa5.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
    
    pa6=new pa6_();
    pa6.setBounds(0,490,646,50);  
    pa6.setBackground(background);
    pa6.setBorder(new TitledBorder(new LineBorder(Color.lightGray,1)));
    
    pa2.add(btn1=new JButton(a1___));
    pa2.add(btn2=new JButton(a2___));
    pa2.add(btn3=new JButton(a3___));
    pa2.add(btn4=new JButton(a4___));   
    pa2.add(btn5=new JButton(a5___));
    pa2.add(btn6=new JButton(a6___));
    pa2.add(btn7=new JButton(a7___));
    pa2.add(btn8=new JButton(a8___));
    pa2.add(btn9=new JButton(a9___));
    pa2.add(btn10=new JButton(a10___));
    pa2.add(btn11=new JButton(a11___));
    pa2.add(btn12=new JButton(a12___));
    pa2.add(btn13=new JButton(a13___));
    pa2.add(btn14=new JButton(a14___));
    pa2.add(btn15=new JButton(a15___));
    pa2.add(btn16=new JButton(a16___));
    pa2.add(btn17=new JButton(a17___));
    pa2.add(btn18=new JButton(a18___));
    pa2.add(btn19=new JButton(a19___));
    pa2.add(btn20=new JButton(a20___));
    pa2.add(btn21=new JButton(a21___));
    pa2.add(btn22=new JButton(a22___));
    pa2.add(btn23=new JButton(a23___));
    pa2.add(btn24=new JButton(a24___));
    pa2.add(btn25=new JButton(a25___));
    pa2.add(btn26=new JButton(a26___));
    pa2.add(btn27=new JButton(a27___));
    pa2.add(btn28=new JButton(a28___));
    pa2.add(btn29=new JButton(a29___));
    pa2.add(btn30=new JButton(a30___));
    pa2.add(btn31=new JButton(a31___));  
   
   ActionListener button =new ActionListener() {
       public void actionPerformed(ActionEvent e) {
           for(int i=0;i<15;i++) {
              cho_[i]=null;
              }
           j=0;
           if(e.getSource()==btn1)
              cho_[j]="ㄱ";cho_[j+1]="/";         
           if(e.getSource()==btn2)
              cho_[j]="ㄴ";cho_[j+1]="/";
           if(e.getSource()==btn3)
              cho_[j]="ㄷ";cho_[j+1]="/";
           if(e.getSource()==btn4)
              cho_[j]="ㄹ";cho_[j+1]="/";
           if(e.getSource()==btn5)
              cho_[j]="ㅁ";cho_[j+1]="/";
           if(e.getSource()==btn6)
              cho_[j]="ㅂ";cho_[j+1]="/";
           if(e.getSource()==btn7)
              cho_[j]="ㅅ";cho_[j+1]="/";
           if(e.getSource()==btn8)
              cho_[j]="ㅇ";cho_[j+1]="/";
           if(e.getSource()==btn9)
              cho_[j]="ㅈ";cho_[j+1]="/";
           if(e.getSource()==btn10)
              cho_[j]="ㅊ";cho_[j+1]="/";
           if(e.getSource()==btn11)
              cho_[j]="ㅋ";cho_[j+1]="/";
           if(e.getSource()==btn12)
              cho_[j]="ㅌ";cho_[j+1]="/";
           if(e.getSource()==btn13)
              cho_[j]="ㅍ";cho_[j+1]="/";
           if(e.getSource()==btn14)
              cho_[j]="ㅎ";cho_[j+1]="/";
           if(e.getSource()==btn15)
              cho_[j]="ㅏ";cho_[j+1]="/";
           if(e.getSource()==btn16)
              cho_[j]="ㅑ";cho_[j+1]="/";
           if(e.getSource()==btn17)
              cho_[j]="ㅓ";cho_[j+1]="/";
           if(e.getSource()==btn18)
              cho_[j]="ㅕ";cho_[j+1]="/";
           if(e.getSource()==btn19)
              cho_[j]="ㅗ";cho_[j+1]="/";
           if(e.getSource()==btn20)
              cho_[j]="ㅛ";cho_[j+1]="/";
           if(e.getSource()==btn21)
              cho_[j]="ㅜ";cho_[j+1]="/";
           if(e.getSource()==btn22)
              cho_[j]="ㅠ";cho_[j+1]="/";           
           if(e.getSource()==btn23)
              cho_[j]="ㅡ";cho_[j+1]="/";
           if(e.getSource()==btn24)
              cho_[j]="ㅣ";cho_[j+1]="/";
           if(e.getSource()==btn25)
              cho_[j]="ㅐ";cho_[j+1]="/";
           if(e.getSource()==btn26)
              cho_[j]="ㅒ";cho_[j+1]="/";
           if(e.getSource()==btn27)
              cho_[j]="ㅔ";cho_[j+1]="/";
           if(e.getSource()==btn28)
              cho_[j]="ㅖ";cho_[j+1]="/";
           if(e.getSource()==btn29)
              cho_[j]="ㅢ";cho_[j+1]="/";
           if(e.getSource()==btn30)
              cho_[j]="ㅚ";cho_[j+1]="/";
           if(e.getSource()==btn31)
              cho_[j]="ㅟ";cho_[j+1]="/";
           pa5.repaint();
       }};
   
        btn1.addActionListener(button);
        btn2.addActionListener(button);
        btn3.addActionListener(button);
        btn4.addActionListener(button);
        btn5.addActionListener(button);
        btn6.addActionListener(button);
        btn7.addActionListener(button);
        btn8.addActionListener(button);
        btn9.addActionListener(button);
        btn10.addActionListener(button);
        btn11.addActionListener(button);
        btn12.addActionListener(button);
        btn13.addActionListener(button);
        btn14.addActionListener(button);
        btn15.addActionListener(button);
        btn16.addActionListener(button);
        btn17.addActionListener(button);
        btn18.addActionListener(button);
        btn19.addActionListener(button);
        btn20.addActionListener(button);
        btn21.addActionListener(button);
        btn22.addActionListener(button);
        btn23.addActionListener(button);
        btn24.addActionListener(button);
        btn25.addActionListener(button);
        btn26.addActionListener(button);
        btn27.addActionListener(button);
        btn28.addActionListener(button);
        btn29.addActionListener(button);
        btn30.addActionListener(button);
        btn31.addActionListener(button);
    
   JLabel la = new JLabel("번역하고 싶은 단어를 입력하세요"); 
   la.setFont(new Font("고딕", Font.BOLD, 40));
   la.setSize(650,50);
   la.setLocation(170,50);
   pa4.add(la);
   
   JTextField ff=new JTextField(10);
   ff.setSize(600,100);
   ff.setLocation(180,130);
   ff.setFont(new Font("고딕",Font.BOLD,30));
   pa4.add(ff);

   ff.addActionListener(new ActionListener() { 
         public void actionPerformed(ActionEvent e) {// 텍스트를 누르고 enter누르면 이거 실행 됨 ㅎ
            JTextField t = (JTextField)e.getSource();
            tempStr = t.getText();//문자열 받아옴
            List<Map<String, Integer>> list = new ArrayList<Map<String, Integer>>();
            String lastStr = "";
            for(int i=0;i<15;i++) {
               cho_[i]=null;
               }

                for(int i =0,j=0;  i < tempStr.length() ; i++,j++){//입력 받은 단어의 길이만큼 돌려

                   Map<String, Integer> map = new HashMap<String, Integer>();
                   char test = tempStr.charAt(i);
                   
                   if(test >= 0xAC00 && test <=0xD7A3){ // test가 한글이면?
                      char uniVal = (char) (test - 0xAC00);
                      char ja = (char) (((uniVal - (uniVal % 28))/28)/21);
                      char mo = (char) (((uniVal - (uniVal % 28))/28)%21);
                      char jong = (char) (uniVal %28);               
                      String a1 = String.valueOf(JA[ja]); // 초성을 char->String
                      if(JA[ja]=='ㄲ') {
                             cho_[j]="ㄱ";j++;
                             cho_[j]="ㄱ";
                          }
                         else if(JA[ja]=='ㄸ') {
                             cho_[j]="ㄷ";j++;
                             cho_[j]="ㄷ";
                          }
                         else if(JA[ja]=='ㅆ') {
                             cho_[j]="ㅅ";j++;
                             cho_[j]="ㅅ";
                          }
                         else if(JA[ja]=='ㅉ') {
                             cho_[j]="ㅈ";j++;
                             cho_[j]="ㅈ";
                          }
                         else if(JA[ja]=='ㅆ') {
                             cho_[j]="ㅅ";j++;
                             cho_[j]="ㅅ";
                          }
                         else if(JA[ja]=='ㅃ') {
                             cho_[j]="ㅂ";j++;
                             cho_[j]="ㅂ";
                          }
                         else {
                            cho_[j]=a1;
                          }
                      j++; 
                      String a2 = String.valueOf(MO[mo]);
                      if(MO[mo]=='ㅘ') {
                            cho_[j]="ㅗ";j++;
                            cho_[j]="ㅏ";
                         }
                         else if(MO[mo]=='ㅙ') {
                            cho_[j]="ㅗ";j++;
                            cho_[j]="ㅐ";
                         }
                         else if(MO[mo]=='ㅝ') {
                            cho_[j]="ㅜ";j++;
                            cho_[j]="ㅓ";
                         }
                         else if(MO[mo]=='ㅞ') {
                            cho_[j]="ㅜ";j++;
                            cho_[j]="ㅔ";
                         }
                         else {
                            cho_[j]=a2;
                         }

                      
                      if((char)jong != 0x0000) {
                         j++;
                         if(JONG[jong]=='ㄳ') {
                             cho_[j]="ㄱ";j++;
                             cho_[j]="ㅅ";                          
                             }
                         else if(JONG[jong]=='ㄵ') {
                            cho_[j]="ㄴ";j++;
                             cho_[j]="ㅈ";
                         }
                         else if(JONG[jong]=='ㄶ') {
                            cho_[j]="ㄴ";j++;
                             cho_[j]="ㅎ";
                         }
                        
                         else if(JONG[jong]=='ㄺ') {
                            cho_[j]="ㄹ";j++;
                             cho_[j]="ㄱ";
                         }
                         else if(JONG[jong]=='ㄻ') {
                            cho_[j]="ㄹ";
                            j++;
                             cho_[j]="ㅁ";
                         }
                         else if(JONG[jong]=='ㄽ') {
                            cho_[j]="ㄹ";j++;
                             cho_[j]="ㅅ";
                         }
                         else if(JONG[jong]=='ㄾ') {
                            cho_[j]="ㄹ";j++;
                             cho_[j]="ㅌ";
                         }
                         else if(JONG[jong]=='ㅀ') {
                            cho_[j]="ㄹ";j++;
                             cho_[j]="ㅎ";
                         }
                         else if(JONG[jong]=='ㅄ') {
                            cho_[j]="ㅂ";j++;
                             cho_[j]="ㅅ";
                         }
                         else if(JONG[jong]=='ㄿ') {
                            cho_[j]="ㄹ";j++;
                             cho_[j]="ㅍ";
                         }
                         else { 
                            String a3 = String.valueOf(JONG[jong]);
                            cho_[j]=a3;    
                            }
                         }
                      map.put("ja", (int) ja);
                      map.put("mo", (int) mo);
                      map.put("jong", (int) jong);
                      list.add(map);
                      } // if(test >= 0xAC00) //한글이면?
                   if(i==tempStr.length()-1) {
                      j++;
                      cho_[j]="/";
                      }
                   } 
                // for(int i = 0 ; i < tempStr.length();i++)

                for(int i = 0; i < list.size() ; i++){
                   int a = (int)(list.get(i)).get("ja");
                   int b = (int)(list.get(i)).get("mo");
                   int c = (int)(list.get(i)).get("jong");
                   char temp = (char)(0xAC00 + 28 * 21 *(a) + 28 * (b) + (c) );
                   lastStr = lastStr.concat(String.valueOf(temp));
                   }
                pa3.repaint();
                j=0;
                pa5.repaint();
            
             } //public void actionPerformed(ActionEvent e)
             
          });
    
    c.add(pa1);      c.add(pa2);      c.add(pa3);      c.add(pa4);      c.add(pa5);   c.add(pa6); 
    setSize(1920,1060);
    setVisible(true);
 }
 
class finger extends JPanel{//손가락 그리기
  public void paintComponent(Graphics g) {
     super.paintComponent(g);
     g.setColor(Color.BLACK);
     if (PalmPosition != null) {g.fillOval(350+(int) PalmPosition.getX(),400-(int) PalmPosition.getY(), 10, 10);}
     if (THUMB_1 != null) {g.fillOval(350+(int) THUMB_1.getX(),400-(int) THUMB_1.getY(), 10, 10);}
     if (THUMB_2 != null) {g.fillOval(350+(int) THUMB_2.getX(),400-(int) THUMB_2.getY(), 10, 10);}
     if (THUMB_3 != null) {g.fillOval(350+(int) THUMB_3.getX(),400-(int) THUMB_3.getY(), 10, 10);}         
     if (INDEX_1 != null) {g.fillOval(350+(int) INDEX_1.getX(),400-(int) INDEX_1.getY(), 10, 10);}
     if (INDEX_2 != null) {g.fillOval(350+(int) INDEX_2.getX(),400-(int) INDEX_2.getY(), 10, 10);}
     if (INDEX_3 != null) {g.fillOval(350+(int) INDEX_3.getX(),400-(int) INDEX_3.getY(), 10, 10);}
     if (INDEX_4 != null) {g.fillOval(350+(int) INDEX_4.getX(),400-(int) INDEX_4.getY(), 10, 10);}         
     if (MIDDLE_1 != null) {g.fillOval(350+(int) MIDDLE_1.getX(),400-(int) MIDDLE_1.getY(), 10, 10);}
     if (MIDDLE_2 != null) {g.fillOval(350+(int) MIDDLE_2.getX(),400-(int) MIDDLE_2.getY(), 10, 10);}
     if (MIDDLE_3 != null) {g.fillOval(350+(int) MIDDLE_3.getX(),400-(int) MIDDLE_3.getY(), 10, 10);}
     if (MIDDLE_4 != null) {g.fillOval(350+(int) MIDDLE_4.getX(),400-(int) MIDDLE_4.getY(), 10, 10);}         
     if (RING_1 != null) {g.fillOval(350+(int) RING_1.getX(),400-(int) RING_1.getY(), 10, 10);}
     if (RING_2 != null) {g.fillOval(350+(int) RING_2.getX(),400-(int) RING_2.getY(), 10, 10);}
     if (RING_3 != null) {g.fillOval(350+(int) RING_3.getX(),400-(int) RING_3.getY(), 10, 10);}
     if (RING_4 != null) {g.fillOval(350+(int) RING_4.getX(),400-(int) RING_4.getY(), 10, 10);}         
     if (PINKY_1 != null) {g.fillOval(350+(int) PINKY_1.getX(),400-(int) PINKY_1.getY(), 10, 10);}
     if (PINKY_2 != null) {g.fillOval(350+(int) PINKY_2.getX(),400-(int) PINKY_2.getY(), 10, 10);}
     if (PINKY_3 != null) {g.fillOval(350+(int) PINKY_3.getX(),400-(int) PINKY_3.getY(), 10, 10);}
     if (PINKY_4 != null) {g.fillOval(350+(int) PINKY_4.getX(),400-(int) PINKY_4.getY(), 10, 10);
        g.drawLine(350+(int) THUMB_1.getX()+5,400-(int) THUMB_1.getY()+5,350+(int) THUMB_2.getX()+5,400-(int) THUMB_2.getY()+5);
        g.drawLine(350+(int) THUMB_2.getX()+5,400-(int) THUMB_2.getY()+5,350+(int) THUMB_3.getX()+5,400-(int) THUMB_3.getY()+5);
        g.drawLine(350+(int) INDEX_1.getX()+5,400-(int) INDEX_1.getY()+5,350+(int) INDEX_2.getX()+5,400-(int) INDEX_2.getY()+5);
        g.drawLine(350+(int) INDEX_2.getX()+5,400-(int) INDEX_2.getY()+5,350+(int) INDEX_3.getX()+5,400-(int) INDEX_3.getY()+5);
        g.drawLine(350+(int) INDEX_3.getX()+5,400-(int) INDEX_3.getY()+5,350+(int) INDEX_4.getX()+5,400-(int) INDEX_4.getY()+5);
        g.drawLine(350+(int) MIDDLE_1.getX()+5,400-(int) MIDDLE_1.getY()+5,350+(int) MIDDLE_2.getX()+5,400-(int) MIDDLE_2.getY()+5);
        g.drawLine(350+(int) MIDDLE_2.getX()+5,400-(int) MIDDLE_2.getY()+5,350+(int) MIDDLE_3.getX()+5,400-(int) MIDDLE_3.getY()+5);
        g.drawLine(350+(int) MIDDLE_3.getX()+5,400-(int) MIDDLE_3.getY()+5,350+(int) MIDDLE_4.getX()+5,400-(int) MIDDLE_4.getY()+5);
        g.drawLine(350+(int) RING_1.getX()+5,400-(int) RING_1.getY()+5,350+(int) RING_2.getX()+5,400-(int) RING_2.getY()+5);
        g.drawLine(350+(int) RING_2.getX()+5,400-(int) RING_2.getY()+5,350+(int) RING_3.getX()+5,400-(int) RING_3.getY()+5);
        g.drawLine(350+(int) RING_3.getX()+5,400-(int) RING_3.getY()+5,350+(int)  RING_4.getX()+5,400-(int)  RING_4.getY()+5);
        g.drawLine(350+(int) PINKY_1.getX()+5,400-(int) PINKY_1.getY()+5,350+(int) PINKY_2.getX()+5,400-(int) PINKY_2.getY()+5);
        g.drawLine(350+(int) PINKY_2.getX()+5,400-(int) PINKY_2.getY()+5,350+(int) PINKY_3.getX()+5,400-(int) PINKY_3.getY()+5);
        g.drawLine(350+(int) PINKY_3.getX()+5,400-(int) PINKY_3.getY()+5,350+(int) PINKY_4.getX()+5,400-(int) PINKY_4.getY()+5);
        }         
        }
}

class pa3_ extends JPanel{
   public void paintComponent(Graphics g2) {
      super.paintComponent(g2);
      if(tempStr!=null) {
         for(int i=0; i<15;i++) {
            if(cho_[i]!=null) {
               if(cho_[i]!="/") {
                 g2.setFont(new Font("고딕", Font.BOLD, 40));
                  g2.setColor(Color.BLACK);
                  g2.drawString(cho_[i],40+i*50,100);
                  }
               }
            }
         }
   }
}
class pa5_ extends JPanel{
     public void paintComponent(Graphics h) {
        super.paintComponent(h);
        if(cho_[j]!=null) {
            switch(cho_[j]) {
              case "ㄱ":h.drawImage(h1_,180,110,600,300,this);break;
              case "ㄴ":h.drawImage(h2_,180,110,600,300,this);break;
              case "ㄷ":h.drawImage(h3_,180,110,600,300,this);break;
              case "ㄹ":h.drawImage(h4_,180,110,600,300,this);break;
              case "ㅁ":h.drawImage(h5_,180,110,600,300,this);break;
              case "ㅂ":h.drawImage(h6_,180,110,600,300,this);break;
              case "ㅅ":h.drawImage(h7_,180,110,600,300,this);break;
              case "ㅇ":h.drawImage(h8_,180,110,600,300,this);break;
              case "ㅈ":h.drawImage(h9_,180,110,600,300,this);break;
              case "ㅊ":h.drawImage(h10_,180,110,600,300,this);break;
              case "ㅋ":h.drawImage(h11_,180,110,600,300,this);break;
              case "ㅌ":h.drawImage(h12_,180,110,600,300,this);break;
              case "ㅍ":h.drawImage(h13_,180,110,600,300,this);break;
              case "ㅎ":h.drawImage(h14_,180,110,600,300,this);break;
              case "ㅏ":h.drawImage(h15_,180,110,600,300,this);break;
              case "ㅑ":h.drawImage(h16_,180,110,600,300,this);break;
              case "ㅓ":h.drawImage(h17_,180,110,600,300,this);break;
              case "ㅕ":h.drawImage(h18_,180,110,600,300,this);break;
              case "ㅗ":h.drawImage(h19_,180,110,600,300,this);break;
              case "ㅛ":h.drawImage(h20_,180,110,600,300,this);break;
              case "ㅜ":h.drawImage(h21_,180,110,600,300,this);break;
              case "ㅠ":h.drawImage(h22_,180,110,600,300,this);break;
              case "ㅡ":h.drawImage(h23_,180,110,600,300,this);break;
              case "ㅣ":h.drawImage(h24_,180,110,600,300,this);break;
              case "ㅐ":h.drawImage(h25_,180,110,600,300,this);break;
              case "ㅒ":h.drawImage(h26_,180,110,600,300,this);break;
              case "ㅔ":h.drawImage(h27_,180,110,600,300,this);break;
              case "ㅖ":h.drawImage(h28_,180,110,600,300,this);break;
              case "ㅢ":h.drawImage(h29_,180,110,600,300,this);break;
              case "ㅚ":h.drawImage(h30_,180,110,600,300,this);break;
              case "ㅟ":h.drawImage(h31_,180,110,600,300,this);break;
              case "/" :h.drawImage(a32_,0,0,960,520,this);break;
        }
        }
     }
     }

class pa6_ extends JPanel{
   public void paintComponent(Graphics g) {
      super.paintComponent(g);
      if(rece!=null) {
      g.setFont(new Font("고딕", Font.BOLD, 30));
      g.setColor(Color.BLACK);
      g.drawString("인식된 지화  : "+rece,175,35);}
      }
   }
}

class SampleListener extends Listener {
      float PalmPosition_x = 0;
      float PalmPosition_x_ = 0;
      float PalmPosition_y = 0;
      float PalmPosition_y_ = 0;
      float PalmPosition_z = 0;
      float PalmPosition_z_ = 0;
      float THUMB_1_x = 0;
      float THUMB_1_x_ = 0;
      float THUMB_1_y = 0;
      float THUMB_1_y_ = 0;
      float THUMB_1_z = 0;
      float THUMB_1_z_ = 0;
      float THUMB_2_x = 0;
      float THUMB_2_x_ = 0;
      float THUMB_2_y = 0;
      float THUMB_2_y_ = 0;
      float THUMB_2_z = 0;
      float THUMB_2_z_ = 0;
      float THUMB_3_x = 0;
      float THUMB_3_x_ = 0;
      float THUMB_3_y = 0;
      float THUMB_3_y_ = 0;
      float THUMB_3_z = 0;
      float THUMB_3_z_ = 0;
      float INDEX_1_x = 0;
      float INDEX_1_x_ = 0;
      float INDEX_1_y = 0;
      float INDEX_1_y_ = 0;
      float INDEX_1_z = 0;
      float INDEX_1_z_ = 0;
      float INDEX_2_x = 0;
      float INDEX_2_x_ = 0;
      float INDEX_2_y = 0;
      float INDEX_2_y_ = 0;
      float INDEX_2_z = 0;
      float INDEX_2_z_ = 0;
      float INDEX_3_x = 0;
      float INDEX_3_x_ = 0;
      float INDEX_3_y = 0;
      float INDEX_3_y_ = 0;
      float INDEX_3_z = 0;
      float INDEX_3_z_ = 0;
      float INDEX_4_x = 0;
      float INDEX_4_x_ = 0;
      float INDEX_4_y = 0;
      float INDEX_4_y_ = 0;
      float INDEX_4_z = 0;
      float INDEX_4_z_ = 0;
      float MIDDLE_1_x = 0;
      float MIDDLE_1_x_ = 0;
      float MIDDLE_1_y = 0;
      float MIDDLE_1_y_ = 0;
      float MIDDLE_1_z = 0;
      float MIDDLE_1_z_ = 0;
      float MIDDLE_2_x = 0;
      float MIDDLE_2_x_ = 0;
      float MIDDLE_2_y = 0;
      float MIDDLE_2_y_ = 0;
      float MIDDLE_2_z = 0;
      float MIDDLE_2_z_ = 0;
      float MIDDLE_3_x = 0;
      float MIDDLE_3_x_ = 0;
      float MIDDLE_3_y = 0;
      float MIDDLE_3_y_ = 0;
      float MIDDLE_3_z = 0;
      float MIDDLE_3_z_ = 0;
      float MIDDLE_4_x = 0;
      float MIDDLE_4_x_ = 0;
      float MIDDLE_4_y = 0;
      float MIDDLE_4_y_ = 0;
      float MIDDLE_4_z = 0;
      float MIDDLE_4_z_ = 0;
      float RING_1_x = 0;
      float RING_1_x_ = 0;
      float RING_1_y = 0;
      float RING_1_y_ = 0;
      float RING_1_z = 0;
      float RING_1_z_ = 0;
      float RING_2_x = 0;
      float RING_2_x_ = 0;
      float RING_2_y = 0;
      float RING_2_y_ = 0;
      float RING_2_z = 0;
      float RING_2_z_ = 0;
      float RING_3_x = 0;
      float RING_3_x_ = 0;
      float RING_3_y = 0;
      float RING_3_y_ = 0;
      float RING_3_z = 0;
      float RING_3_z_ = 0;
      float RING_4_x = 0;
      float RING_4_x_ = 0;
      float RING_4_y = 0;
      float RING_4_y_ = 0;
      float RING_4_z = 0;
      float RING_4_z_ = 0;
      float PINKY_1_x = 0;
      float PINKY_1_x_ = 0;
      float PINKY_1_y = 0;
      float PINKY_1_y_ = 0;
      float PINKY_1_z = 0;
      float PINKY_1_z_ = 0;
      float PINKY_2_x = 0;
      float PINKY_2_x_ = 0;
      float PINKY_2_y = 0;
      float PINKY_2_y_ = 0;
      float PINKY_2_z = 0;
      float PINKY_2_z_ = 0;
      float PINKY_3_x = 0;
      float PINKY_3_x_ = 0;
      float PINKY_3_y = 0;
      float PINKY_3_y_ = 0;
      float PINKY_3_z = 0;
      float PINKY_3_z_ = 0;
      float PINKY_4_x = 0;
      float PINKY_4_x_ = 0;
      float PINKY_4_y = 0;
      float PINKY_4_y_ = 0;
      float PINKY_4_z = 0;
      float PINKY_4_z_ = 0;
      float THUMB_direction_x = 0;
      float THUMB_direction_y = 0;
      float THUMB_direction_z = 0;
      float INDEX_direction_x = 0;
      float INDEX_direction_y = 0;
      float INDEX_direction_z = 0;
      float MIDDLE_direction_x = 0;
      float MIDDLE_direction_y = 0;
      float MIDDLE_direction_z = 0;
      float RING_direction_x = 0;
      float RING_direction_y = 0;
      float RING_direction_z = 0;
      float PINKY_direction_x = 0;
      float PINKY_direction_y = 0;
      float PINKY_direction_z = 0;

      panel g = null;

      public void onConnect(Controller controller) {
         System.out.println("Connected");
        g = new panel();
     
      }

      public void onFrame(Controller controller) {
         Frame frame = controller.frame();
         
         for (Hand hand : frame.hands()) {
            String handType = hand.isLeft() ? "왼손" : "오른손";
            Vector PalmPosition = hand.palmPosition();
            Vector normal = hand.palmNormal();
            PalmPosition_x = PalmPosition.getX();
            PalmPosition_y = PalmPosition.getY();
            PalmPosition_z = PalmPosition.getZ();
            PalmPosition_x_ = PalmPosition_x - PalmPosition_x;
            PalmPosition_y_ = PalmPosition_y - PalmPosition_y;
            PalmPosition_z_ = PalmPosition_z - PalmPosition_z;
            g.PalmPosition(PalmPosition);
            /*
             * System.out.println("=============== " + handType + " ===============");
             * System.out.println("§ 손바닥 중앙 좌표(중앙) : " + PalmPosition_x_ + "," +
             * PalmPosition_y_ + "," + PalmPosition_z_);
             */
            for (Finger finger : hand.fingers()) {
               Type FingerType = finger.type();
               String FingerTypeName = "";
               switch (FingerType) {
               case TYPE_THUMB:
                  FingerTypeName = "엄지손가락";
                  for (Bone.Type boneType : Bone.Type.values()) {
                     Bone bone = finger.bone(boneType);
                     String BoneTypeName = "";
                     Vector BoneNextJoint = bone.nextJoint();
                     Vector direction = finger.direction();
                     switch (boneType) {
                     case TYPE_DISTAL:
                        BoneTypeName = " > 1 : ";
                        THUMB_1_x = BoneNextJoint.getX();
                        THUMB_1_y = BoneNextJoint.getY();
                        THUMB_1_z = BoneNextJoint.getZ();
                        THUMB_direction_x = direction.getX();
                        THUMB_direction_y = direction.getY();
                        THUMB_direction_z = direction.getZ();
                        THUMB_1_x_ = THUMB_1_x - PalmPosition_x;
                        THUMB_1_y_ = THUMB_1_y - PalmPosition_y;
                        THUMB_1_z_ = THUMB_1_z - PalmPosition_z;
                        g.THUMB_1(BoneNextJoint);
                        break;

                     case TYPE_INTERMEDIATE:
                        BoneTypeName = " > 2 : ";
                        THUMB_2_x = BoneNextJoint.getX();
                        THUMB_2_y = BoneNextJoint.getY();
                        THUMB_2_z = BoneNextJoint.getZ();
                        THUMB_2_x_ = THUMB_2_x - PalmPosition_x;
                        THUMB_2_y_ = THUMB_2_y - PalmPosition_y;
                        THUMB_2_z_ = THUMB_2_z - PalmPosition_z;
                        g.THUMB_2(BoneNextJoint);
                        break;

                     case TYPE_PROXIMAL:
                        BoneTypeName = " > 3 : ";
                        THUMB_3_x = BoneNextJoint.getX();
                        THUMB_3_y = BoneNextJoint.getY();
                        THUMB_3_z = BoneNextJoint.getZ();
                        THUMB_3_x_ = THUMB_3_x - PalmPosition_x;
                        THUMB_3_y_ = THUMB_3_y - PalmPosition_y;
                        THUMB_3_z_ = THUMB_3_z - PalmPosition_z;
                        g.THUMB_3(BoneNextJoint);
                        break;
                     }
                  } // for( Bone.Type boneType : Bone.Type.values() )
                  break; // case TYPE_THTHUMBB

               case TYPE_INDEX:
                  FingerTypeName = "검지손가락";
                  for (Bone.Type boneType : Bone.Type.values()) {
                     Bone bone = finger.bone(boneType);
                     String BoneTypeName = "";
                     Vector BoneNextJoint = bone.nextJoint();
                     Vector direction = finger.direction();
                     switch (boneType) {
                     case TYPE_DISTAL:
                        BoneTypeName = " > 1 : ";
                        INDEX_1_x = BoneNextJoint.getX();
                        INDEX_1_y = BoneNextJoint.getY();
                        INDEX_1_z = BoneNextJoint.getZ();
                        INDEX_1_x_ = INDEX_1_x - PalmPosition_x;
                        INDEX_1_y_ = INDEX_1_y - PalmPosition_y;
                        INDEX_1_z_ = INDEX_1_z - PalmPosition_z;
                        INDEX_direction_x = direction.getX();
                        INDEX_direction_y = direction.getY();
                        INDEX_direction_z = direction.getZ();
                        g.INDEX_1(BoneNextJoint);
                        break;

                     case TYPE_INTERMEDIATE:
                        BoneTypeName = " > 2 : ";
                        INDEX_2_x = BoneNextJoint.getX();
                        INDEX_2_y = BoneNextJoint.getY();
                        INDEX_2_z = BoneNextJoint.getZ();
                        INDEX_2_x_ = INDEX_2_x - PalmPosition_x;
                        INDEX_2_y_ = INDEX_2_y - PalmPosition_y;
                        INDEX_2_z_ = INDEX_2_z - PalmPosition_z;
                        g.INDEX_2(BoneNextJoint);
                        break;

                     case TYPE_PROXIMAL:
                        BoneTypeName = " > 3 : ";
                        INDEX_3_x = BoneNextJoint.getX();
                        INDEX_3_y = BoneNextJoint.getY();
                        INDEX_3_z = BoneNextJoint.getZ();
                        INDEX_3_x_ = INDEX_3_x - PalmPosition_x;
                        INDEX_3_y_ = INDEX_3_y - PalmPosition_y;
                        INDEX_3_z_ = INDEX_3_z - PalmPosition_z;
                        g.INDEX_3(BoneNextJoint);
                        break;

                     case TYPE_METACARPAL:
                        BoneTypeName = " > 4 : ";
                        INDEX_4_x = BoneNextJoint.getX();
                        INDEX_4_y = BoneNextJoint.getY();
                        INDEX_4_z = BoneNextJoint.getZ();
                        INDEX_4_x_ = INDEX_4_x - PalmPosition_x;
                        INDEX_4_y_ = INDEX_4_y - PalmPosition_y;
                        INDEX_4_z_ = INDEX_4_z - PalmPosition_z;
                        g.INDEX_4(BoneNextJoint);
                        break;
                     }
                  } // for( Bone.Type boneType : Bone.Type.values() )
                  break; // case TYPE_INDEX

               case TYPE_MIDDLE:
                  FingerTypeName = "중지손가락";
                  for (Bone.Type boneType : Bone.Type.values()) {
                     Bone bone = finger.bone(boneType);
                     String BoneTypeName = "";
                     Vector BoneNextJoint = bone.nextJoint();
                     Vector direction = finger.direction();
                     switch (boneType) {
                     case TYPE_DISTAL:
                        BoneTypeName = " > 1 : ";
                        MIDDLE_1_x = BoneNextJoint.getX();
                        MIDDLE_1_y = BoneNextJoint.getY();
                        MIDDLE_1_z = BoneNextJoint.getZ();
                        MIDDLE_1_x_ = MIDDLE_1_x - PalmPosition_x;
                        MIDDLE_1_y_ = MIDDLE_1_y - PalmPosition_y;
                        MIDDLE_1_z_ = MIDDLE_1_z - PalmPosition_z;
                        MIDDLE_direction_x = direction.getX();
                        MIDDLE_direction_y = direction.getY();
                        MIDDLE_direction_z = direction.getZ();
                        g.MIDDLE_1(BoneNextJoint);
                        break;

                     case TYPE_INTERMEDIATE:
                        BoneTypeName = " > 2 : ";
                        MIDDLE_2_x = BoneNextJoint.getX();
                        MIDDLE_2_y = BoneNextJoint.getY();
                        MIDDLE_2_z = BoneNextJoint.getZ();
                        MIDDLE_2_x_ = MIDDLE_2_x - PalmPosition_x;
                        MIDDLE_2_y_ = MIDDLE_2_y - PalmPosition_y;
                        MIDDLE_2_z_ = MIDDLE_2_z - PalmPosition_z;
                        g.MIDDLE_2(BoneNextJoint);
                        break;

                     case TYPE_PROXIMAL:
                        BoneTypeName = " > 3 : ";
                        MIDDLE_3_x = BoneNextJoint.getX();
                        MIDDLE_3_y = BoneNextJoint.getY();
                        MIDDLE_3_z = BoneNextJoint.getZ();
                        MIDDLE_3_x_ = MIDDLE_3_x - PalmPosition_x;
                        MIDDLE_3_y_ = MIDDLE_3_y - PalmPosition_y;
                        MIDDLE_3_z_ = MIDDLE_3_z - PalmPosition_z;
                        g.MIDDLE_3(BoneNextJoint);
                        break;

                     case TYPE_METACARPAL:
                        BoneTypeName = " > 4 : ";
                        MIDDLE_4_x = BoneNextJoint.getX();
                        MIDDLE_4_y = BoneNextJoint.getY();
                        MIDDLE_4_z = BoneNextJoint.getZ();
                        MIDDLE_4_x_ = MIDDLE_4_x - PalmPosition_x;
                        MIDDLE_4_y_ = MIDDLE_4_y - PalmPosition_y;
                        MIDDLE_4_z_ = MIDDLE_4_z - PalmPosition_z;
                        g.MIDDLE_4(BoneNextJoint);
                        break;
                     }
                  } // for( Bone.Type boneType : Bone.Type.values() )
                  break; // case TYPE_MIDDLE

               case TYPE_RING:
                  FingerTypeName = "약지손가락";
                  for (Bone.Type boneType : Bone.Type.values()) {
                     Bone bone = finger.bone(boneType);
                     String BoneTypeName = "";
                     Vector BoneNextJoint = bone.nextJoint();
                     Vector direction = finger.direction();
                     switch (boneType) {
                     case TYPE_DISTAL:
                        BoneTypeName = " > 1 : ";
                        RING_1_x = BoneNextJoint.getX();
                        RING_1_y = BoneNextJoint.getY();
                        RING_1_z = BoneNextJoint.getZ();
                        RING_1_x_ = RING_1_x - PalmPosition_x;
                        RING_1_y_ = RING_1_y - PalmPosition_y;
                        RING_1_z_ = RING_1_z - PalmPosition_z;
                        RING_direction_x = direction.getX();
                        RING_direction_y = direction.getY();
                        RING_direction_z = direction.getZ();
                        g.RING_1(BoneNextJoint);
                        break;

                     case TYPE_INTERMEDIATE:
                        BoneTypeName = " > 2 : ";
                        RING_2_x = BoneNextJoint.getX();
                        RING_2_y = BoneNextJoint.getY();
                        RING_2_z = BoneNextJoint.getZ();
                        RING_2_x_ = RING_2_x - PalmPosition_x;
                        RING_2_y_ = RING_2_y - PalmPosition_y;
                        RING_2_z_ = RING_2_z - PalmPosition_z;
                        g.RING_2(BoneNextJoint);
                        break;

                     case TYPE_PROXIMAL:
                        BoneTypeName = " > 3 : ";
                        RING_3_x = BoneNextJoint.getX();
                        RING_3_y = BoneNextJoint.getY();
                        RING_3_z = BoneNextJoint.getZ();
                        RING_3_x_ = RING_3_x - PalmPosition_x;
                        RING_3_y_ = RING_3_y - PalmPosition_y;
                        RING_3_z_ = RING_3_z - PalmPosition_z;
                        g.RING_3(BoneNextJoint);
                        break;

                     case TYPE_METACARPAL:
                        BoneTypeName = " > 4 : ";
                        RING_4_x = BoneNextJoint.getX();
                        RING_4_y = BoneNextJoint.getY();
                        RING_4_z = BoneNextJoint.getZ();
                        RING_4_x_ = RING_4_x - PalmPosition_x;
                        RING_4_y_ = RING_4_y - PalmPosition_y;
                        RING_4_z_ = RING_4_z - PalmPosition_z;
                        g.RING_4(BoneNextJoint);
                        break;
                     }
                  } // for( Bone.Type boneType : Bone.Type.values() )
                  break; // case TYPE_RING

               case TYPE_PINKY:
                  FingerTypeName = "새끼손가락";
                  for (Bone.Type boneType : Bone.Type.values()) {
                     Bone bone = finger.bone(boneType);
                     String BoneTypeName = "";
                     Vector BoneNextJoint = bone.nextJoint();
                     Vector direction = finger.direction();
                     switch (boneType) {
                     case TYPE_DISTAL:
                        BoneTypeName = " > 1 : ";
                        PINKY_1_x = BoneNextJoint.getX();
                        PINKY_1_y = BoneNextJoint.getY();
                        PINKY_1_z = BoneNextJoint.getZ();
                        PINKY_1_x_ = PINKY_1_x - PalmPosition_x;
                        PINKY_1_y_ = PINKY_1_y - PalmPosition_y;
                        PINKY_1_z_ = PINKY_1_z - PalmPosition_z;
                        PINKY_direction_x = direction.getX();
                        PINKY_direction_y = direction.getY();
                        PINKY_direction_z = direction.getZ();
                        g.PINKY_1(BoneNextJoint);
                        break;

                     case TYPE_INTERMEDIATE:
                        BoneTypeName = " > 2 : ";
                        PINKY_2_x = BoneNextJoint.getX();
                        PINKY_2_y = BoneNextJoint.getY();
                        PINKY_2_z = BoneNextJoint.getZ();
                        PINKY_2_x_ = PINKY_2_x - PalmPosition_x;
                        PINKY_2_y_ = PINKY_2_y - PalmPosition_y;
                        PINKY_2_z_ = PINKY_2_z - PalmPosition_z;
                        g.PINKY_2(BoneNextJoint);
                        break;

                     case TYPE_PROXIMAL:
                        BoneTypeName = " > 3 : ";
                        PINKY_3_x = BoneNextJoint.getX();
                        PINKY_3_y = BoneNextJoint.getY();
                        PINKY_3_z = BoneNextJoint.getZ();
                        PINKY_3_x_ = PINKY_3_x - PalmPosition_x;
                        PINKY_3_y_ = PINKY_3_y - PalmPosition_y;
                        PINKY_3_z_ = PINKY_3_z - PalmPosition_z;
                        g.PINKY_3(BoneNextJoint);
                        break;

                     case TYPE_METACARPAL:
                        BoneTypeName = " > 4 : ";
                        PINKY_4_x = BoneNextJoint.getX();
                        PINKY_4_y = BoneNextJoint.getY();
                        PINKY_4_z = BoneNextJoint.getZ();
                        PINKY_4_x_ = PINKY_4_x - PalmPosition_x;
                        PINKY_4_y_ = PINKY_4_y - PalmPosition_y;
                        PINKY_4_z_ = PINKY_4_z - PalmPosition_z;
                        g.PINKY_4(BoneNextJoint);
                        break;
                     }
                  } // for( Bone.Type boneType : Bone.Type.values() )
                  break; // case TYPE_PINKY

               } // switch(FingerType)
            } // for ( Finger finger : hand.fingers() )
         } // for( Hand hand : frame.hands() )
         
      /*     System.out.println( "30 1:" + THUMB_1_x_ + " 2:" + THUMB_1_y_ + " 3:" +
           THUMB_1_z_ + " 4:" + THUMB_2_x_ + " 5:" + THUMB_2_y_ + " 6:" + THUMB_2_z_ +
           " 7:" + THUMB_3_x_ + " 8:" + THUMB_3_y_ + " 9:" + THUMB_3_z_ + " 10:" +
           INDEX_1_x_ + " 11:" + INDEX_1_y_ + " 12:" + INDEX_1_z_ + " 13:" + INDEX_2_x_
           + " 14:" + INDEX_2_y_ + " 15:" + INDEX_2_z_ + " 16:" + INDEX_3_x_ + " 17:" +
           INDEX_3_y_ + " 18:" + INDEX_3_z_ + " 19:" + INDEX_4_x_ + " 20:" + INDEX_4_y_
           + " 21:" + INDEX_4_z_ + " 22:" + MIDDLE_1_x_ + " 23:" + MIDDLE_1_y_ + " 24:"
           + MIDDLE_1_z_ + " 25:" + MIDDLE_2_x_ + " 26:" + MIDDLE_2_y_ + " 27:" +
           MIDDLE_2_z_ + " 28:" + MIDDLE_3_x_ + " 29:" + MIDDLE_3_y_ + " 30:" +
           MIDDLE_3_z_ + " 31:" + MIDDLE_4_x_ + " 32:" + MIDDLE_4_y_ + " 33:" +
           MIDDLE_4_z_ + " 34:" + RING_1_x_ + " 35:" + RING_1_y_ + " 36:" + RING_1_z_ +
           " 37:" + RING_2_x_ + " 38:" + RING_2_y_ + " 39:" + RING_2_z_ + " 40:" +
           RING_3_x_ + " 41:" + RING_3_y_ + " 42:" + RING_3_z_ + " 43:" + RING_4_x_ +
           " 44:" + RING_4_y_ + " 45:" + RING_4_z_ + " 46:" + PINKY_1_x_ + " 47:" +
           PINKY_1_y_ + " 48:" + PINKY_1_z_ + " 49:" + PINKY_2_x_ + " 50:" + PINKY_2_y_
           + " 51:" + PINKY_2_z_ + " 52:" + PINKY_3_x_ + " 53:" + PINKY_3_y_ + " 54:" +
           PINKY_3_z_ + " 55:" + PINKY_4_x_ + " 56:" + PINKY_4_y_ + " 57:" + PINKY_4_z_ +
           " 58:" + THUMB_direction_x + " 59:" + THUMB_direction_y + " 60:" + THUMB_direction_z +
           " 61:" + INDEX_direction_x + " 62:"+ INDEX_direction_y + " 63:"+ INDEX_direction_z + " 64:" 
           + MIDDLE_direction_x + " 65:" + MIDDLE_direction_y + " 66:" + MIDDLE_direction_z + " 67:" 
           + RING_direction_x + " 68:" + RING_direction_y + " 69:"+ RING_direction_z + " 70:" + PINKY_direction_x 
           + " 71:" + RING_direction_y + " 72:" + + RING_direction_z);*/           
         
         String message = "0 1:" + THUMB_1_x_ + " 2:" + THUMB_1_y_ + " 3:" + THUMB_1_z_ + " 4:" + THUMB_2_x_ + " 5:" + THUMB_2_y_ + " 6:"
               + THUMB_2_z_ + " 7:" + THUMB_3_x_ + " 8:" + THUMB_3_y_ + " 9:" + THUMB_3_z_ + " 10:" + INDEX_1_x_ + " 11:" + INDEX_1_y_ + " 12:"
               + INDEX_1_z_ + " 13:" + INDEX_2_x_ + " 14:" + INDEX_2_y_ + " 15:" + INDEX_2_z_ + " 16:" + INDEX_3_x_ + " 17:" + INDEX_3_y_
               + " 18:" + INDEX_3_z_ + " 19:" + INDEX_4_x_ + " 20:" + INDEX_4_y_ + " 21:" + INDEX_4_z_ + " 22:" + MIDDLE_1_x_ + " 23:"
               + MIDDLE_1_y_ + " 24:" + MIDDLE_1_z_ + " 25:" + MIDDLE_2_x_ + " 26:" + MIDDLE_2_y_ + " 27:" + MIDDLE_2_z_ + " 28:" + MIDDLE_3_x_
               + " 29:" + MIDDLE_3_y_ + " 30:" + MIDDLE_3_z_ + " 31:" + MIDDLE_4_x_ + " 32:" + MIDDLE_4_y_ + " 33:" + MIDDLE_4_z_ + " 34:"
               + RING_1_x_ + " 35:" + RING_1_y_ + " 36:" + RING_1_z_ + " 37:" + RING_2_x_ + " 38:" + RING_2_y_ + " 39:" + RING_2_z_
               + " 40:" + RING_3_x_ + " 41:" + RING_3_y_ + " 42:" + RING_3_z_ + " 43:" + RING_4_x_ + " 44:" + RING_4_y_ + " 45:"
               + RING_4_z_ + " 46:" + PINKY_1_x_ + " 47:" + PINKY_1_y_ + " 48:" + PINKY_1_z_ + " 49:" + PINKY_2_x_ + " 50:" + PINKY_2_y_
               + " 51:" + PINKY_2_z_ + " 52:" + PINKY_3_x_ + " 53:" + PINKY_3_y_ + " 54:" + PINKY_3_z_ + " 55:" + PINKY_4_x_ + " 56:"
               + PINKY_4_y_ + " 57:" + PINKY_4_z_ + " 58:" + THUMB_direction_x + " 59:" + THUMB_direction_y + " 60:" + THUMB_direction_z +
               " 61:" + INDEX_direction_x + " 62:"+ INDEX_direction_y + " 63:"+ INDEX_direction_z + " 64:" 
               + MIDDLE_direction_x + " 65:" + MIDDLE_direction_y + " 66:" + MIDDLE_direction_z + " 67:" 
               + RING_direction_x + " 68:" + RING_direction_y + " 69:"+ RING_direction_z + " 70:" + PINKY_direction_x 
               + " 71:" + RING_direction_y + " 72:" + RING_direction_z + "\n";

         File test = new File("test1.txt");
         FileWriter writer = null;

         try {
            // 기존 파일의 내용에 이어서 쓰려면 true를, 기존 내용을 없애고 새로 쓰려면 false를 지정한다.
            writer = new FileWriter(test, false);
            writer.write(message);
            writer.flush();

         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            try {
               if (writer != null)
                  writer.close();
            } catch (IOException e) {
               e.printStackTrace();
            }
         } // public void onFrame(Controller controller)
         
         class Cmd {
             private StringBuffer buffer;
             private Process process;
             private BufferedReader bufferedReader;
             private StringBuffer readBuffer;
             
             public String inputCommand(String cmd) {
                buffer = new StringBuffer();
                buffer.append("cmd.exe ");
                buffer.append("/c ");
                buffer.append(cmd);
                return buffer.toString();
             }
             
             public String execCommand(String cmd) {
                try {
                   process = Runtime.getRuntime().exec(cmd);
                   bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                   String line = null;
                   readBuffer = new StringBuffer();
                   while ((line = bufferedReader.readLine()) != null) {
                      readBuffer.append(line);
                      readBuffer.append("\n");
                      }
                   return readBuffer.toString();
                   } //try
                catch (Exception e) {
                   e.printStackTrace();
                   System.exit(1);
                   } //catch
             return null;
             }
          }

           Cmd cmd= new Cmd();
           String command = cmd.inputCommand("svm-predict C:\\eclipse-workspace\\Panel\\test1.txt C:\\libsvm-3.23\\windows\\train2.txt.model result.txt");
           String result = cmd.execCommand(command);        
       //  System.out.println(result);
           String[] splitedStr = null;

           File file= new File("C:\\eclipse-workspace\\Panel\\result.txt");       
               try {
                  BufferedReader reader = new BufferedReader(new FileReader(file)); // BufferedReader 변수에 file을 넣는다
                  String line = null; // 파일을 한줄씩 읽어 넣기 위한 변수 line
                  splitedStr = null; // 하나의 line을 split 하여 넣을 배열 splitedStr
                  while( (line = reader.readLine()) != null ) { // 한 줄씩 읽어서 line에 넣은 후 null이 아니면 실행
                     splitedStr = null; // 초기화
                     splitedStr = line.split("\n"); // 탭을 기준으로 잘라서 splitedStr 에 넣는다
                     for (int i = 0; i < splitedStr.length; i++) { // 배열에 들어간 길이 만큼 반복한다
                        splitedStr[i] = splitedStr[i].trim(); // 양쪽의 공백을 제거하고 다시 입력한다
                        }// splitedStr 을 List<Class명>에 입력하는 등 이용가능하다
                   }
                  reader.close();
                  }
               catch (FileNotFoundException fnf) {
                  fnf.printStackTrace();
                  }
               catch( IOException e) {
                  e.printStackTrace();
                  }

               String RetGet0 = "";
               String resultt = "";
              
         for(int i = 0 ; i<splitedStr.length ; i++){
          RetGet0 = splitedStr[i];
            switch(RetGet0) {
            case "0" : resultt = "ㄱ";  break;
            case "1" : resultt = "ㄴ";  break;
            case "2" : resultt = "ㄷ";  break;
            case "3" : resultt = "ㄹ";  break;
            case "4" : resultt = "ㅁ";  break;
            case "5" : resultt = "ㅂ";  break;
            case "6" : resultt = "ㅅ";  break;
            case "7" : resultt = "ㅇ";  break;
            case "8" : resultt = "ㅈ";  break;
            case "9" : resultt = "ㅊ";  break;
            case "10" : resultt = "ㅋ"; break;
            case "11" : resultt = "ㅌ"; break;
            case "12" : resultt = "ㅍ"; break;
            case "13" : resultt = "ㅎ"; break;
            case "14" : resultt = "ㅏ"; break;
            case "15" : resultt = "ㅑ"; break;
            case "16" : resultt = "ㅓ"; break;
            case "17" : resultt = "ㅕ"; break;
            case "18" : resultt = "ㅗ"; break;
            case "19" : resultt = "ㅛ"; break;
            case "20" : resultt = "ㅜ"; break;
            case "21" : resultt = "ㅠ"; break;
            case "22" : resultt = "ㅡ"; break;
            case "23" : resultt = "ㅣ"; break;
            case "24" : resultt = "ㅐ"; break;
            case "25" : resultt = "ㅒ"; break;
            case "26" : resultt = "ㅔ"; break;
            case "27" : resultt = "ㅖ"; break;
            case "28" : resultt = "ㅢ"; break;
            case "29" : resultt = "ㅚ"; break;
            case "30" : resultt = "ㅟ"; break;
           } // switch 닫음
           g.rece(resultt);
        System.out.println(resultt);
        } //for 닫음
      } //public void onFrame(Controller controller)
     }  //class SampleListener extends Listener


   public class Sample extends SampleListener{
       public static void main(String[] args) throws IOException {        
          SampleListener listener = new SampleListener(); 
           Controller controller = new Controller();        
           controller.addListener(listener);
           System.out.println("Leap Motion이 연결되지 않음.");
      try{ System.in.read(); }
       catch(IOException e){ e.printStackTrace(); }        
       controller.removeListener(listener);       
       }
   }
