/*    */ package swingprojects;
/*    */ 
/*    */ import javax.swing.JFrame;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Snake
/*    */ {
/* 11 */   JFrame frame = new JFrame();
/*    */ 
/*    */ 
/*    */   
/*    */   Snake() {
/* 16 */     this.frame.add(new snakePanel());
/* 17 */     this.frame.setTitle("Snake");
/* 18 */     this.frame.setDefaultCloseOperation(3);
/*    */     
/* 20 */     this.frame.setResizable(false);
/* 21 */     this.frame.pack();
/* 22 */     this.frame.setVisible(true);
/*    */   }
/*    */ }


/* Location:              F:\Work Maybe\My Fucking Projects\my-snake\My Fucking Snake.jar!\swingprojects\Snake.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */