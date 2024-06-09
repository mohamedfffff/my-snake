/*     */ package swingprojects;
/*     */ import java.awt.Color;
/*     */ import java.awt.Font;
/*     */ import java.awt.FontMetrics;
/*     */ import java.awt.Graphics;
/*     */ import java.awt.event.KeyEvent;
/*     */ import java.io.File;
/*     */ import java.util.Random;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.sound.sampled.AudioInputStream;
/*     */ import javax.sound.sampled.AudioSystem;
/*     */ import javax.sound.sampled.Clip;
/*     */ import javax.sound.sampled.LineUnavailableException;
/*     */ import javax.swing.Timer;
/*     */ 
/*     */ public class snakePanel extends JPanel implements ActionListener, KeyListener {
/*  18 */   final int panel_hight = 600; final int panel_width = 600; final int blocksSize = 25;
/*  19 */   int blocksNumber = 576; int snakeParts = 3;
/*  20 */   int[] x = new int[this.blocksNumber];
/*  21 */   int[] y = new int[this.blocksNumber];
/*  22 */   int delay = 175; int score = 0; int xApple;
/*     */   int yApple;
/*     */   boolean running = false;
/*  25 */   char direction = 'R';
/*     */   Random random;
/*     */   Timer timer;
/*     */   
/*     */   snakePanel() {
/*  30 */     this.random = new Random();
/*  31 */     setPreferredSize(new Dimension(600, 600));
/*  32 */     setBackground(Color.black);
/*  33 */     setOpaque(true);
/*  34 */     setFocusable(true);
/*  35 */     addKeyListener(this);
/*  36 */     start();
/*     */   }
/*     */ 
/*     */   
/*     */   public void start() {
/*  41 */     apple();
/*  42 */     this.running = true;
/*  43 */     this.timer = new Timer(this.delay, this);
/*  44 */     this.timer.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void paintComponent(Graphics g) {
/*  53 */     super.paintComponent(g);
/*  54 */     if (this.running) {
/*  55 */       drawLine(g);
/*  56 */       draw(g);
/*     */     } else {
/*  58 */       gameOver(g);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawLine(Graphics g) {
/*  63 */     for (int x = 0; x < 24; x++) {
/*  64 */       g.drawLine(0, 25 * x, 600, 25 * x);
/*  65 */       g.drawLine(25 * x, 0, 25 * x, 600);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void draw(Graphics g) {
/*  70 */     for (int i = 0; i < this.snakeParts; i++) {
/*  71 */       if (i == 0) {
/*  72 */         g.setColor(new Color(0, 255, 0));
/*  73 */         g.fillRect(this.x[i], this.y[i], 25, 25);
/*     */       } else {
/*  75 */         g.setColor(new Color(0, 180, 0));
/*  76 */         g.fillRect(this.x[i], this.y[i], 25, 25);
/*     */       } 
/*     */     } 
/*  79 */     g.setColor(Color.red);
/*  80 */     g.fillOval(this.xApple, this.yApple, 25, 25);
/*     */     
/*  82 */     g.setColor(Color.red);
/*  83 */     g.setFont(new Font("Ink Free", 1, 40));
/*  84 */     FontMetrics metrics = getFontMetrics(g.getFont());
/*  85 */     g.drawString("Score : " + this.score, 230, 30);
/*     */   }
/*     */ 
/*     */   
/*     */   public void move() {
/*  90 */     for (int i = this.snakeParts; i > 0; i--) {
/*  91 */       this.x[i] = this.x[i - 1];
/*  92 */       this.y[i] = this.y[i - 1];
/*     */     } 
/*     */     
/*  95 */     switch (this.direction) { case 'U':
/*  96 */         this.y[0] = this.y[0] - 25; break;
/*  97 */       case 'D': this.y[0] = this.y[0] + 25; break;
/*  98 */       case 'L': this.x[0] = this.x[0] - 25; break;
/*  99 */       case 'R': this.x[0] = this.x[0] + 25;
/*     */         break; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void score() {
/* 106 */     if (this.x[0] == this.xApple && this.y[0] == this.yApple) {
/* 107 */       this.score++;
/* 108 */       this.snakeParts++;
/* 109 */       audio("score.WAV");
/* 110 */       apple();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void death() throws InterruptedException {
/* 115 */     if (this.x[0] < 0 || this.x[0] > 575 || this.y[0] < 0 || this.y[0] > 575) {
/* 116 */       this.running = false;
/* 117 */       gameOver();
/* 118 */       audio("lose.WAV");
/* 119 */       Thread.sleep(1000L);
/*     */     } 
/* 121 */     for (int i = this.snakeParts; i > 0; i--) {
/* 122 */       if (this.x[0] == this.x[i] && this.y[0] == this.y[i]) {
/* 123 */         this.running = false;
/* 124 */         gameOver();
/* 125 */         audio("lose.WAV");
/* 126 */         Thread.sleep(1000L);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void gameOver(Graphics g) {
/* 135 */     g.setColor(Color.red);
/* 136 */     g.setFont(new Font("Ink Free", 1, 40));
/* 137 */     FontMetrics metrics1 = getFontMetrics(g.getFont());
/* 138 */     g.drawString("Score: " + this.score, 230, 230);
/*     */     
/* 140 */     g.setColor(Color.red);
/* 141 */     g.setFont(new Font("Ink Free", 1, 75));
/* 142 */     FontMetrics metrics2 = getFontMetrics(g.getFont());
/* 143 */     g.drawString("Game Over", 120, 310);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void gameOver() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void apple() {
/* 153 */     this.xApple = this.random.nextInt(24) * 25;
/* 154 */     this.yApple = this.random.nextInt(24) * 25;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/* 160 */     if (this.running) {
/* 161 */       move();
/* 162 */       score();
/*     */       try {
/* 164 */         death();
/* 165 */       } catch (InterruptedException ex) {
/* 166 */         Logger.getLogger(snakePanel.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */       } 
/*     */     } 
/* 169 */     repaint();
/*     */   }
/*     */ 
/*     */   
/*     */   public void keyPressed(KeyEvent e) {
/* 174 */     int keyCode = e.getKeyCode();
/* 175 */     switch (keyCode) { case 38:
/* 176 */         if (this.direction != 'D') this.direction = 'U';  break;
/* 177 */       case 40: if (this.direction != 'U') this.direction = 'D';  break;
/* 178 */       case 37: if (this.direction != 'R') this.direction = 'L';  break;
/* 179 */       case 39: if (this.direction != 'L') this.direction = 'R';  break; }
/*     */     
/* 181 */     audio("turn.WAV");
/*     */   }
/*     */   
/*     */   public void audio(String s) {
/* 185 */     File file = new File(s);
/*     */     try {
/* 187 */       AudioInputStream a = AudioSystem.getAudioInputStream(file);
/* 188 */       Clip c = AudioSystem.getClip();
/* 189 */       c.open(a);
/* 190 */       c.start();
/* 191 */     } catch (UnsupportedAudioFileException ex) {
/* 192 */       Logger.getLogger(snakePanel.class.getName()).log(Level.SEVERE, (String)null, ex);
/* 193 */     } catch (IOException ex) {
/* 194 */       Logger.getLogger(snakePanel.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     }
/* 196 */     catch (LineUnavailableException ex) {
/* 197 */       Logger.getLogger(snakePanel.class.getName()).log(Level.SEVERE, (String)null, ex);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void keyTyped(KeyEvent e) {}
/*     */   
/*     */   public void keyReleased(KeyEvent e) {}
/*     */ }


/* Location:              F:\Work Maybe\My Fucking Projects\my-snake\My Fucking Snake.jar!\swingprojects\snakePanel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */