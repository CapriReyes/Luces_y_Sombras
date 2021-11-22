package Inicio;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JPanel;

public class Panel extends JPanel{
    Lienzo lienzo;
    GLCanvas canvas;
    public Panel() {
        lienzo=new Lienzo();
        canvas=new GLCanvas(new GLCapabilities());
        canvas.addGLEventListener(lienzo);
        canvas.setBounds(0, 0, 1200,700);
        add(canvas);
        canvas.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_W){
                    lienzo.cambiarPosicion(0, 0.1,0);
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    lienzo.cambiarPosicion(-0.1, 0,0);
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    lienzo.cambiarPosicion(0, -0.1,0);
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    lienzo.cambiarPosicion(0.1, 0,0);
                }
                if(e.getKeyCode()==KeyEvent.VK_Z){
                    lienzo.cambiarPosicion(0, 0,0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_X){
                    lienzo.cambiarPosicion(0, 0,-0.1);
                }
                if(e.getKeyCode()==KeyEvent.VK_T){
                    lienzo.cambiarRotacion(0, 1, 0, 0);
                }
                if(e.getKeyCode()==KeyEvent.VK_Y){
                    lienzo.cambiarRotacion(0, 0, 1, 0);
                }
                if(e.getKeyCode()==KeyEvent.VK_U){
                    lienzo.cambiarRotacion(0, 0, 0, 1);
                }
                if(e.getKeyCode()==KeyEvent.VK_G){
                    lienzo.cambiarRotacion(0, -1, 0, 0);
                }
                if(e.getKeyCode()==KeyEvent.VK_H){
                    lienzo.cambiarRotacion(0, 0, -1, 0);
                }
                if(e.getKeyCode()==KeyEvent.VK_J){
                    lienzo.cambiarRotacion(0, 0, 0, -1);
                }
                if(e.getKeyCode()==KeyEvent.VK_V){
                    lienzo.cambiarRotacion(1, 0, 0, 0);
                }
                if(e.getKeyCode()==KeyEvent.VK_B){
                    lienzo.cambiarRotacion(-1, 0, 0, 0);
                }
                if(e.getKeyCode()==KeyEvent.VK_Q){
                    lienzo.grado=0;
                    lienzo.x0=0;
                    lienzo.y0=0;
                    lienzo.z0=0;
                    lienzo.xpos=0;
                    lienzo.ypos=0;
                    lienzo.zpos=0;
                }
                canvas.repaint();
            }
            @Override
            public void keyReleased(KeyEvent e) {}
        });
    }
}
