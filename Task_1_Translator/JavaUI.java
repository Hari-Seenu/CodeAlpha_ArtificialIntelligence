
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JavaUI {
    
    public static void main(String[] args) {
        Color prim = new Color(0x01204E);     
        Color sec = new Color(0x028391);      
        Color bgg = new Color(0xF6DCAC);     
        Color bg = new Color(0xFAA968);
        Color acce = new Color(0xF85525);
        JFrame tr = new JFrame();
        tr.setTitle("Translator");
        tr.setSize(580, 800);
        tr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tr.setLayout(new BorderLayout(10, 10));//gap between each components in frame (horizantal gap and vertical gap)
        tr.getContentPane().setBackground(bg);
 //------------------------------------------------------------------------------------------------
        //Heading of translator
        JPanel Headings = new JPanel();//Top title Card pannel
        Headings.setBackground(bg);
        Headings.setLayout(new BoxLayout(Headings,BoxLayout.Y_AXIS));//for top to bottom allighnemt

        JLabel heads = new JLabel();
        heads.setText("🌐 Language Translator");
        heads.setFont(new Font("Segoe UI",Font.BOLD,24));
        heads.setBackground(sec);
        heads.setForeground(sec);
        heads.setAlignmentX(Component.CENTER_ALIGNMENT);//for center allignment
        Headings.add(heads);

        JLabel devloper = new  JLabel();
        devloper.setText("Translates 10+ Languages");
        devloper.setFont(new Font("Segoe UI",Font.ITALIC,16));
        devloper.setBackground(sec);
        devloper.setForeground(sec);
        devloper.setAlignmentX(Component.CENTER_ALIGNMENT);
        Headings.add(devloper);
        tr.add(Headings,BorderLayout.NORTH);//headings in top of frame(tr) so, north
//------------------------------------------------------------------------------------------------------

        //center and operation(communication or intraction) pannel
        JPanel cenop = new JPanel(new GridLayout(2,1,10,10));//adding two components input pannel and out put pannel in row wise so 2, in same collumn so 2, exah component have 10 gap in hori and verti
        cenop.setBackground(bg);
        cenop.setForeground(acce);
        cenop.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //input Section
        JPanel inputsec = new JPanel(new BorderLayout(5,5));//making border layout.it contain 5 regions[north,south,east,west and centet] make 5 ver and hori gap between components in inputsec panel 
        inputsec.setBackground(acce);
        JLabel inp = new JLabel();//asking for enter text
        inp.setText("     Enter your text: ");
        inp.setBackground(bgg);
        inp.setFont(new Font("Segoe UI",Font.BOLD,15));

        JTextArea input=new JTextArea(3,25);//getting text from user
        input.setFont(new Font("Segoe UI", Font.BOLD, 15));
        input.setLineWrap(true);//for consider new line after pressing enter in input section
        input.setWrapStyleWord(true);//java can able to break words if auto_move_nextline. yhis line help to avoid breaking the line
        JScrollPane inputscroll = new JScrollPane(input);//add scrollbar for input section.nor input inside/holded by inputscroll
        input.setForeground(prim);
        input.setBackground(bgg);
        inputscroll.setBorder(BorderFactory.createLineBorder(acce,1));
        inputscroll.setBackground(bg);
        //adding label and text area toinput section
        inputsec.add(inp,BorderLayout.NORTH);//label in nort region
        inputsec.add(inputscroll,BorderLayout.CENTER);//input colum in bolttom og label(center region)

        //output Section
        JPanel outputsec = new JPanel(new BorderLayout(5,5));
        outputsec.setBackground(acce);
        JLabel out = new JLabel();
        out.setBackground(new Color(27,127,127));
        out.setFont(new Font("Segoe UI",Font.BOLD,15));
        out.setText("     Translated Text");
        outputsec.add(out,BorderLayout.NORTH);
        out.setForeground(prim);

        JTextArea output = new JTextArea(3,25);
        output.setFont(new Font("Arial Unicode MS",Font.BOLD,15));
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setEditable(false);
        output.setForeground(prim);
        output.setBackground(bgg);
        JScrollPane outputscroll = new JScrollPane(output);
        outputscroll.setBorder(BorderFactory.createLineBorder(acce,1));
        
        //adding label and text area on output section
        outputsec.add(out,BorderLayout.NORTH);
        outputsec.add(outputscroll,BorderLayout.CENTER);

        //adding input and output section on central operation panel.
        cenop.add(inputsec);//cenop uses grid layout.(2row,1colums,10,h and v gap. so not uses borderlay out to specifi north and center )
        cenop.add(outputsec);

        //adding central operation section to tr
        tr.add(cenop,BorderLayout.CENTER);
//-------------------------------------------------------------------------------------------------------------------------------
        //Buttons section

        JPanel bottem = new JPanel(new GridLayout(2,1,10,10));//all bottens in left to right so no need for border or grid layout
        bottem.setBackground(bg);
        bottem.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        

        //Language section section
        JPanel langpan = new JPanel();
        langpan.setBackground(acce);
        String[] lan ={ "Tamil","English", "Spanish", "French", "German", "Italian","Portuguese", "Hindi", "Chinese", "Japanese", "Arabic"};
        String[] cod ={"ta","en", "es", "fr", "de", "it","pt", "hi", "zh", "ja", "ar"};
        JComboBox<String> sourcelanguage = new JComboBox<>(lan);
        sourcelanguage.setSelectedIndex(1);//default selection
        sourcelanguage.setPreferredSize(new Dimension(140, 35));
        sourcelanguage.setBackground(sec);
        
        JComboBox<String> destinlanguage = new JComboBox<>(lan);
        destinlanguage.setSelectedIndex(0);//default selection
        destinlanguage.setPreferredSize(new Dimension(140, 35));
        destinlanguage.setBackground(sec);
        
        //destinlanguage.setForeground(Color.white);
        JLabel from = new JLabel("From: ");
        JLabel to = new JLabel("To: ");
        langpan.add(from);
        langpan.add(sourcelanguage);
        langpan.add(to);
        langpan.add(destinlanguage);
        
        //button pannel
        JPanel buttons = new JPanel();
        buttons.setBackground(bg);
        JButton trans = new JButton();//Translate Button
        trans.setText("🌐 Translate");
        trans.setFont(new Font("Segoe UI",Font.BOLD,15));
        trans.setBackground(sec);
        trans.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String txt = input.getText().trim();
                if(txt.isEmpty()){
                    output.setText("Enter Some text to translate");
                }
                else{
                    output.setText(txt);
                }
            }
        });
        
        JButton clear = new JButton();//Clear Button
        clear.setText("🗑 Clear");
        clear.setFont(new Font("Segoe UI",Font.BOLD,15));
        clear.setBackground(acce);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(input.getText().isEmpty()){
                    output.setText("Are You Kidding? ");
                }
                else{
                    output.setText("");
                    input.setText("");
                }
            }
        });
       
        JButton copy = new JButton();//Copy Button
        copy.setText("📋 Copy");
        copy.setFont(new Font("Segoe UI",Font.BOLD,15));
        copy.setBackground(acce);
        copy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if(output.getText().isEmpty()){
                    JOptionPane.showMessageDialog(copy, "No Text In Output", "Kiruttu", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    StringSelection txt = new StringSelection(output.getText());
                    Clipboard cp = Toolkit.getDefaultToolkit().getSystemClipboard();
                    cp.setContents(txt, null);
                }
            }
        });

        
        buttons.add(clear);
        buttons.add(trans);
        buttons.add(copy);
        
        bottem.add(langpan);
        bottem.add(buttons);

        tr.add(bottem,BorderLayout.SOUTH);
        
        tr.setVisible(true);
    }
    
}
