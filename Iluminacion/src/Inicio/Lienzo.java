package Inicio;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

public class Lienzo implements GLEventListener{
    GL gl;
    GLU glu;
    GLUT glut;
    
    float grado=0;
    float x0=0,y0=0,z0=0;   
    float xpos=0 , ypos=0, zpos=0;
    // Inicia definición de materiales
    final float[] mat_ambiente = {0.2f, 0.2f, 0.2f, 1.0f};
    final float[] mat_difuso = {0.8f, 0.8f, 0.8f, 1.0f};
    final float[] mat_especular = {0.0f, 0.0f, 0.0f, 1.0f};
    final float[] mat_brillo = {10.0f};
    
    private float[][] vertices = { {-0.5f, -0.5f, -0.5f}, 
                                   { 0.5f, -0.5f, -0.5f},
                                   { 0.5f,  0.5f, -0.5f}, 
                                   {-0.5f,  0.5f, -0.5f}, 
                                   {-0.5f, -0.5f,  0.5f},
                                   { 0.5f, -0.5f,  0.5f}, 
                                   { 0.5f,  0.5f,  0.5f}, 
                                   {-0.5f,  0.5f,  0.5f}};
    
    private float[][] normales = {{-1.0f,-1.0f,-1.0f},
                                 {1.0f,-1.0f,-1.0f},
                                 {1.0f,1.0f,-1.0f}, 
                                 {-1.0f,1.0f,-1.0f}, 
                                 {-1.0f,-1.0f,1.0f}, 
                                 {1.0f,-1.0f,1.0f}, 
                                 {1.0f,1.0f,1.0f}, 
                                 {-1.0f,1.0f,1.0f}};
    
    public void cambiarPosicion(double x,double y,double z){
        xpos+=x;
        ypos+=y;
        zpos+=z;
    }
    public void cambiarRotacion(double Grado,double x,double y, double z){
        grado+=Grado;
        x0+=x;
        y0+=y;
        z0+=z;
    }
    
    @Override
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL(); // inicializa la variable GL

        gl.glClearColor(0.5f, 0.5f, 1.0f, 0.0f);

        // Parametros de la luz 0
        float[] luzAmbiente = {0.2f, 0.2f, 0.2f, 1.0f};
        float[] luzDifusa = {1.0f, 0.0f, 1.0f, 1.0f};
        float[] luzEspecular = {0.0f, 0.0f, 0.0f, 1.0f};
        float[] posicion = {1.0f, 1.0f, 1.0f, 1.0f};

        // Se setean los parámetros
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, luzAmbiente, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, luzDifusa, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, luzEspecular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posicion, 0);

        gl.glEnable(GL.GL_DEPTH_TEST); // Habilita el ocultamiento de superficies
        gl.glEnable(GL.GL_LIGHTING); // Habilita la iluminacion
        gl.glEnable(GL.GL_LIGHT0); // Habilita la luz 0 que previamente se habia seteado
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        GLUT glut = new GLUT();

        // borra buffer y el z-buffer
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        glu.gluLookAt(0.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);

        // Superficie
        gl.glMaterialfv(GL.GL_LEFT, GL.GL_AMBIENT, mat_ambiente, 0);
        gl.glMaterialfv(GL.GL_LEFT, GL.GL_DIFFUSE, mat_difuso, 0);
        gl.glMaterialfv(GL.GL_LEFT, GL.GL_SPECULAR, mat_especular, 0);
        gl.glMaterialfv(GL.GL_LEFT, GL.GL_SHININESS, mat_brillo,0);
        gl.glPushMatrix();
            gl.glRotatef(grado,x0,y0,z0);
            gl.glTranslated(xpos, ypos, zpos);
            gl.glBegin(GL.GL_QUADS);
                gl.glNormal3fv(normales[0],0);
		gl.glVertex3fv(vertices[0],0);
		gl.glNormal3fv(normales[3],0);
		gl.glVertex3fv(vertices[3],0);
		gl.glNormal3fv(normales[2],0);
		gl.glVertex3fv(vertices[2],0);
		gl.glNormal3fv(normales[1],0);
		gl.glVertex3fv(vertices[1],0);
            gl.glEnd();
            // Posterior
            gl.glBegin(GL.GL_QUADS);
                gl.glNormal3fv(normales[2],0);
		gl.glVertex3fv(vertices[2],0);
		gl.glNormal3fv(normales[3],0);
		gl.glVertex3fv(vertices[3],0);
		gl.glNormal3fv(normales[7],0);
		gl.glVertex3fv(vertices[7],0);
		gl.glNormal3fv(normales[6],0);
		gl.glVertex3fv(vertices[6],0);
            gl.glEnd();
            // Derecha
            gl.glBegin(GL.GL_QUADS);
                gl.glNormal3fv(normales[0],0);
		gl.glVertex3fv(vertices[0],0);
		gl.glNormal3fv(normales[4],0);
		gl.glVertex3fv(vertices[4],0);
		gl.glNormal3fv(normales[7],0);
		gl.glVertex3fv(vertices[7],0);
		gl.glNormal3fv(normales[3],0);
		gl.glVertex3fv(vertices[3],0);
            gl.glEnd();
            // Izquierda
            gl.glBegin(GL.GL_QUADS);
                gl.glNormal3fv(normales[1],0);
		gl.glVertex3fv(vertices[1],0);
		gl.glNormal3fv(normales[2],0);
		gl.glVertex3fv(vertices[2],0);
		gl.glNormal3fv(normales[6],0);
		gl.glVertex3fv(vertices[6],0);
		gl.glNormal3fv(normales[5],0);
		gl.glVertex3fv(vertices[5],0);
            gl.glEnd();
            // Superior
            gl.glBegin(GL.GL_QUADS);
                gl.glNormal3fv(normales[4],0);
		gl.glVertex3fv(vertices[4],0);
		gl.glNormal3fv(normales[5],0);
		gl.glVertex3fv(vertices[5],0);
		gl.glNormal3fv(normales[6],0);
		gl.glVertex3fv(vertices[6],0);
		gl.glNormal3fv(normales[7],0);
		gl.glVertex3fv(vertices[7],0);
            gl.glEnd();
            // Inferior
            gl.glBegin(GL.GL_QUADS);
                gl.glNormal3fv(normales[0],0);
		gl.glVertex3fv(vertices[0],0);
		gl.glNormal3fv(normales[1],0);
		gl.glVertex3fv(vertices[1],0);
		gl.glNormal3fv(normales[5],0);
		gl.glVertex3fv(vertices[5],0);
		gl.glNormal3fv(normales[4],0);
		gl.glVertex3fv(vertices[4],0);
            gl.glEnd();
        gl.glPopMatrix();
        drawable.swapBuffers();
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height == 0) {
            height = 1;
        }
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        if (width > height) {
            glu.gluPerspective(45.0f, width / height, 1, 150.0f);
        } else {
            glu.gluPerspective(45.0f, width / height, 1, 150.0f);
        }

        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    @Override
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}
}
