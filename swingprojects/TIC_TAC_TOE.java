/*     */ package swingprojects;
/*     */ import java.awt.Color;
/*     */ import java.awt.Component;
/*     */ import java.awt.GridLayout;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ 
/*     */ public class TIC_TAC_TOE implements ActionListener {
/*     */   boolean xTurn = true;
/*  14 */   int count = 0; boolean draw = false;
/*  15 */   JFrame frame = new JFrame();
/*  16 */   JButton[] Buttons = new JButton[9];
/*  17 */   JPanel panel = new JPanel();
/*     */   
/*     */   TIC_TAC_TOE() {
/*  20 */     this.panel.setLayout(new GridLayout(3, 3));
/*     */     
/*  22 */     for (int x = 0; x < 9; x++) {
/*  23 */       this.Buttons[x] = new JButton("");
/*  24 */       this.Buttons[x].setSize(200, 200);
/*  25 */       this.Buttons[x].setBorder(BorderFactory.createLineBorder(Color.yellow));
/*  26 */       this.Buttons[x].setBackground(Color.gray);
/*  27 */       this.Buttons[x].setFont(new Font("MV Boli", 0, 80));
/*  28 */       this.Buttons[x].setFocusable(false);
/*  29 */       this.Buttons[x].setOpaque(true);
/*  30 */       this.Buttons[x].addActionListener(this);
/*  31 */       this.panel.add(this.Buttons[x]);
/*     */     } 
/*     */     
/*  34 */     this.frame.setSize(600, 600);
/*  35 */     this.frame.setDefaultCloseOperation(3);
/*  36 */     this.frame.setLocationRelativeTo((Component)null);
/*  37 */     this.frame.setResizable(false);
/*     */     
/*  39 */     this.frame.add(this.panel);
/*  40 */     this.frame.setVisible(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/*  47 */     for (int x = 0; x < 9; x++) {
/*  48 */       if (e.getSource() == this.Buttons[x]) {
/*  49 */         printSympol(x);
/*  50 */         this.draw = true;
/*  51 */         check();
/*  52 */         this.count++;
/*     */       } 
/*     */     } 
/*  55 */     if (this.draw == true && this.count == 9) draw(); 
/*     */   }
/*     */   
/*     */   void printSympol(int x) {
/*  59 */     if (this.Buttons[x].getText() == "")
/*  60 */       if (this.xTurn == true) {
/*  61 */         this.Buttons[x].setText("X");
/*  62 */         this.Buttons[x].setForeground(new Color(255, 22, 12));
/*  63 */         this.xTurn = false;
/*     */       }
/*  65 */       else if (!this.xTurn) {
/*  66 */         this.Buttons[x].setText("O");
/*  67 */         this.Buttons[x].setForeground(Color.cyan);
/*  68 */         this.xTurn = true;
/*     */       }  
/*     */   }
/*     */   
/*     */   void check() {
/*  73 */     if (this.Buttons[0].getText() == "X" && this.Buttons[1]
/*  74 */       .getText() == "X" && this.Buttons[2]
/*  75 */       .getText() == "X") {
/*  76 */       xWins(0, 1, 2);
/*     */     }
/*  78 */     if (this.Buttons[3].getText() == "X" && this.Buttons[4]
/*  79 */       .getText() == "X" && this.Buttons[5]
/*  80 */       .getText() == "X")
/*  81 */       xWins(3, 4, 5); 
/*  82 */     if (this.Buttons[6].getText() == "X" && this.Buttons[7]
/*  83 */       .getText() == "X" && this.Buttons[8]
/*  84 */       .getText() == "X")
/*  85 */       xWins(6, 7, 8); 
/*  86 */     if (this.Buttons[0].getText() == "X" && this.Buttons[3]
/*  87 */       .getText() == "X" && this.Buttons[6]
/*  88 */       .getText() == "X")
/*  89 */       xWins(0, 3, 6); 
/*  90 */     if (this.Buttons[1].getText() == "X" && this.Buttons[4]
/*  91 */       .getText() == "X" && this.Buttons[7]
/*  92 */       .getText() == "X")
/*  93 */       xWins(1, 4, 7); 
/*  94 */     if (this.Buttons[2].getText() == "X" && this.Buttons[5]
/*  95 */       .getText() == "X" && this.Buttons[8]
/*  96 */       .getText() == "X")
/*  97 */       xWins(2, 5, 8); 
/*  98 */     if (this.Buttons[0].getText() == "X" && this.Buttons[4]
/*  99 */       .getText() == "X" && this.Buttons[8]
/* 100 */       .getText() == "X")
/* 101 */       xWins(0, 4, 8); 
/* 102 */     if (this.Buttons[2].getText() == "X" && this.Buttons[4]
/* 103 */       .getText() == "X" && this.Buttons[6]
/* 104 */       .getText() == "X")
/* 105 */       xWins(2, 4, 6); 
/* 106 */     if (this.Buttons[0].getText() == "O" && this.Buttons[1]
/* 107 */       .getText() == "O" && this.Buttons[2]
/* 108 */       .getText() == "O") {
/* 109 */       oWins(0, 1, 2);
/*     */     }
/* 111 */     if (this.Buttons[3].getText() == "O" && this.Buttons[4]
/* 112 */       .getText() == "O" && this.Buttons[5]
/* 113 */       .getText() == "O")
/* 114 */       oWins(3, 4, 5); 
/* 115 */     if (this.Buttons[6].getText() == "O" && this.Buttons[7]
/* 116 */       .getText() == "O" && this.Buttons[8]
/* 117 */       .getText() == "O")
/* 118 */       oWins(6, 7, 8); 
/* 119 */     if (this.Buttons[0].getText() == "O" && this.Buttons[3]
/* 120 */       .getText() == "O" && this.Buttons[6]
/* 121 */       .getText() == "O")
/* 122 */       oWins(0, 3, 6); 
/* 123 */     if (this.Buttons[1].getText() == "O" && this.Buttons[4]
/* 124 */       .getText() == "O" && this.Buttons[7]
/* 125 */       .getText() == "O")
/* 126 */       oWins(1, 4, 7); 
/* 127 */     if (this.Buttons[2].getText() == "O" && this.Buttons[5]
/* 128 */       .getText() == "O" && this.Buttons[8]
/* 129 */       .getText() == "O")
/* 130 */       oWins(2, 5, 8); 
/* 131 */     if (this.Buttons[0].getText() == "O" && this.Buttons[4]
/* 132 */       .getText() == "O" && this.Buttons[8]
/* 133 */       .getText() == "O")
/* 134 */       oWins(0, 4, 8); 
/* 135 */     if (this.Buttons[2].getText() == "O" && this.Buttons[4]
/* 136 */       .getText() == "O" && this.Buttons[6]
/* 137 */       .getText() == "O")
/* 138 */       oWins(2, 4, 6); 
/*     */   }
/*     */   void xWins(int a, int b, int c) {
/* 141 */     this.Buttons[a].setBackground(Color.green);
/* 142 */     this.Buttons[b].setBackground(Color.green);
/* 143 */     this.Buttons[c].setBackground(Color.green);
/* 144 */     this.draw = false;
/* 145 */     JOptionPane.showMessageDialog(null, "X Wins");
/* 146 */     disable();
/*     */   }
/*     */   
/*     */   void oWins(int a, int b, int c) {
/* 150 */     this.Buttons[a].setBackground(Color.green);
/* 151 */     this.Buttons[b].setBackground(Color.green);
/* 152 */     this.Buttons[c].setBackground(Color.green);
/* 153 */     this.draw = false;
/* 154 */     JOptionPane.showMessageDialog(null, "O Wins");
/* 155 */     disable();
/*     */   }
/*     */   void draw() {
/* 158 */     JOptionPane.showMessageDialog(null, "Draw");
/* 159 */     disable();
/*     */   }
/*     */   void disable() {
/* 162 */     for (int x = 0; x < 9; x++)
/* 163 */       this.Buttons[x].setEnabled(false); 
/*     */   }
/*     */ }


/* Location:              F:\Work Maybe\My Fucking Projects\my-snake\My Fucking Snake.jar!\swingprojects\TIC_TAC_TOE.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */