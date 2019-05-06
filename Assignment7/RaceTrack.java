import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RaceTrack extends JPanel {
    static BufferedImage car;
    static JPanel p;
    static JButton start;
    static JButton pause;
    static JButton reset;
    static JFrame f;
    public RaceTrack(){
        p = new JPanel();
        p.setLayout(new FlowLayout());
        start=new JButton("Start");
        pause=new JButton("Pause");
        reset=new JButton("Reset");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Im starting");
            }
        });
        pause.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Im pausing");
            }
        });

        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Im resetting");
            }
        });



        p.add(start);
        p.add(pause);
        p.add(reset);
    }



    public static void main(String [] strings){
        RaceTrack r = new RaceTrack();
        f = new JFrame();
        f.setContentPane(r);

        f.add(p);

        f.setSize(500, 200);
        f.setTitle("Race Track");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);


    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            car = ImageIO.read(new File("sportive-car.png"));

        }catch (IOException e){
            System.out.println("wrong path!");
        }

        g.setColor(Color.GRAY);
        g.drawImage(car,20,39, this);
        g.drawImage(car,20,89, this);
        g.drawImage(car,20,139, this);
        g.drawRect(53,50,400,10);
        g.drawRect(53,100,400,10);
        g.drawRect(53,150,400,10);
        g.fillRect(53,50,400,10);
        g.fillRect(53,100,400,10);
        g.fillRect(53,150,400,10);

    }


}
