/*     */ package swingprojects;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ public class stopWatch implements ActionListener {
/*  10 */   JFrame frame = new JFrame();
/*  11 */   JButton ResetButton = new JButton("Reset");
/*  12 */   JButton StartButton = new JButton("Start");
/*  13 */   JLabel label = new JLabel();
/*  14 */   int millSseconds = 0; int secondes = 0; int minutes = 0; int hours = 0;
/*     */   boolean started = false;
/*  16 */   String secondesForm = String.format("%02d", new Object[] { Integer.valueOf(this.secondes) });
/*  17 */   String minutesForm = String.format("%02d", new Object[] { Integer.valueOf(this.minutes) });
/*  18 */   String hoursForm = String.format("%02d", new Object[] { Integer.valueOf(this.hours) });
/*     */   
/*  20 */   Timer timer = new Timer(1000, new ActionListener() {
/*     */         public void actionPerformed(ActionEvent e) {
/*  22 */           stopWatch.this.millSseconds += 1000;
/*  23 */           stopWatch.this.hours = stopWatch.this.millSseconds / 3600000;
/*  24 */           stopWatch.this.minutes = stopWatch.this.millSseconds / 60000 % 60;
/*  25 */           stopWatch.this.secondes = stopWatch.this.millSseconds / 1000 % 60;
/*  26 */           String secondesForm = String.format("%02d", new Object[] { Integer.valueOf(this.this$0.secondes) });
/*  27 */           String minutesForm = String.format("%02d", new Object[] { Integer.valueOf(this.this$0.minutes) });
/*  28 */           String hoursForm = String.format("%02d", new Object[] { Integer.valueOf(this.this$0.hours) });
/*  29 */           stopWatch.this.label.setText(hoursForm + ":" + minutesForm + ":" + secondesForm);
/*     */         }
/*     */       });
/*     */ 
/*     */ 
/*     */   
/*     */   stopWatch() {
/*  36 */     this.label.setText(this.hoursForm + ":" + this.minutesForm + ":" + this.secondesForm);
/*  37 */     this.label.setHorizontalAlignment(0);
/*  38 */     this.label.setBackground(Color.gray);
/*  39 */     this.label.setOpaque(true);
/*  40 */     this.label.setForeground(Color.green);
/*  41 */     this.label.setFont(new Font("Verdana", 0, 70));
/*  42 */     this.label.setBounds(0, 0, 400, 100);
/*     */     
/*  44 */     this.StartButton.setFocusable(false);
/*  45 */     this.StartButton.setText("Start");
/*  46 */     this.StartButton.setFont(new Font("Ink Free", 0, 40));
/*  47 */     this.StartButton.setBounds(0, 100, 200, 100);
/*  48 */     this.StartButton.addActionListener(this);
/*     */     
/*  50 */     this.ResetButton.setFocusable(false);
/*  51 */     this.ResetButton.setText("Reset");
/*  52 */     this.ResetButton.setFont(new Font("Ink Free", 0, 40));
/*  53 */     this.ResetButton.setBounds(200, 100, 200, 100);
/*  54 */     this.ResetButton.addActionListener(this);
/*     */     
/*  56 */     this.frame.setSize(400, 230);
/*  57 */     this.frame.setDefaultCloseOperation(3);
/*  58 */     this.frame.setLocationRelativeTo((Component)null);
/*  59 */     this.frame.setResizable(false);
/*  60 */     this.frame.setLayout((LayoutManager)null);
/*     */     
/*  62 */     this.frame.add(this.ResetButton);
/*  63 */     this.frame.add(this.StartButton);
/*  64 */     this.frame.add(this.label);
/*  65 */     this.frame.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/*  71 */     if (!this.started) {
/*  72 */       if (e.getSource() == this.StartButton) {
/*  73 */         this.StartButton.setText("Stop");
/*  74 */         this.started = true;
/*  75 */         start();
/*     */       }
/*     */     
/*  78 */     } else if (this.started == true && 
/*  79 */       e.getSource() == this.StartButton) {
/*  80 */       this.StartButton.setText("Start");
/*  81 */       this.started = false;
/*  82 */       stop();
/*     */     } 
/*     */     
/*  85 */     if (e.getSource() == this.ResetButton) {
/*  86 */       reset();
/*     */     }
/*     */   }
/*     */   
/*     */   void start() {
/*  91 */     this.timer.start();
/*     */   }
/*     */   void stop() {
/*  94 */     this.timer.stop();
/*     */   }
/*     */   void reset() {
/*  97 */     this.StartButton.setText("Start");
/*  98 */     this.started = false;
/*  99 */     this.timer.stop();
/* 100 */     this.millSseconds = 0;
/* 101 */     this.secondes = 0;
/* 102 */     this.minutes = 0;
/* 103 */     this.hours = 0;
/* 104 */     this.label.setText(this.hoursForm + ":" + this.minutesForm + ":" + this.secondesForm);
/*     */   }
/*     */ }


/* Location:              F:\Work Maybe\My Fucking Projects\my-snake\My Fucking Snake.jar!\swingprojects\stopWatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */