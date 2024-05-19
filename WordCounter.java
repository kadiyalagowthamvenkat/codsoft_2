import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*<applet code="WordCounter.class" height=500 width=1000></applet>*/
public class WordCounter extends Applet implements ActionListener, KeyListener {
    private TextArea inputArea;
    private Label countLabel;
    private Button clearButton;
    private Label enterTextLabel;

    public void init() {
        setLayout(new BorderLayout(5, 5));
        setBackground(new Color(255, 228, 225)); // Misty Rose background
        Panel headingPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        headingPanel.setBackground(new Color(255, 228, 225));
        Label headingLabel = new Label("Gowtham's Word Counter");
        headingLabel.setForeground(new Color(72, 61, 139)); // Dark Slate Blue
        headingLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        Panel inputPanel = new Panel(new BorderLayout());
        inputPanel.setBackground(new Color(255, 228, 225));
        inputArea = new TextArea(4, 30);
        inputArea.setFont(new Font("Verdana", Font.PLAIN, 22));
        inputArea.addKeyListener(this);
        inputPanel.add(inputArea, BorderLayout.CENTER);

        enterTextLabel = new Label("Please enter your text below:");
        enterTextLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
        enterTextLabel.setForeground(new Color(105, 105, 105)); // Dim Gray
        inputPanel.add(enterTextLabel, BorderLayout.NORTH);
        
        add(inputPanel, BorderLayout.CENTER);

        Panel labelPanel = new Panel(new FlowLayout(FlowLayout.CENTER));
        labelPanel.setBackground(new Color(255, 228, 225));
        
        countLabel = new Label("Total words: 0");
        countLabel.setForeground(new Color(0, 128, 0)); // Green
        countLabel.setAlignment(Label.LEFT);
        countLabel.setFont(new Font("Verdana", Font.BOLD, 24));
        labelPanel.add(countLabel);
        
        clearButton = new Button("Clear");
        clearButton.setPreferredSize(new Dimension(100, 30));
        clearButton.setFont(new Font("Verdana", Font.BOLD, 16));
        clearButton.addActionListener(this);
        labelPanel.add(new Label("   "));
        labelPanel.add(clearButton);
        labelPanel.add(new Label("   "));
        
        add(labelPanel, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Clear")) {
            inputArea.setText("");
            updateWordCount();
        }
    }

    public void keyTyped(KeyEvent e) {
        updateWordCount();
    }

    public void keyPressed(KeyEvent e) {}

    public void keyReleased(KeyEvent e) {}

    private void updateWordCount() {
        String inputText = inputArea.getText().trim();
        
        if (inputText.isEmpty()) {
            enterTextLabel.setVisible(true);
            countLabel.setText("Total words: 0");
            return;
        } else {
            enterTextLabel.setVisible(false);
        }
        
        String[] words = inputText.split("[\\s\\p{Punct}]+");
        int wordCount = 0;
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }
        countLabel.setText("Total words: " + wordCount);
    }
}
