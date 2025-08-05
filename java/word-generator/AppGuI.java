import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import wording.WordGen;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class AppGuI extends JPanel implements ActionListener {

    private HashMap<String, JComponent> comps;
    private JLabel statusLabel;
    private WordGen wordGenerator;
    private JTextField inputField;

    public AppGuI() {

        setPreferredSize(new Dimension(350, 164));
        setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        wordGenerator = new WordGen();
        comps = new HashMap<>();
        inputField = new JTextField();
        comps.put("Enter a 7 digit number 2-9", inputField);

        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 22);

        // display all form fields on the main panel
        comps.forEach((l, c) -> {
            Box box = Box.createVerticalBox();
            c.setPreferredSize(new Dimension(340, 30));
            c.setFont(font);
            JPanel labelPane = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JLabel jl = new JLabel(l);
            jl.setFont(font);
            labelPane.add(jl);
            box.add(labelPane);
            box.add(c);
            add(box);
        });

        // add the action buttons
        JButton addRecordButton = new JButton("GENERATE WORDS");
        addRecordButton.addActionListener(this);
        JButton saveTo = new JButton("SAVE TO...");
        saveTo.addActionListener(this);
        JPanel p = new JPanel();
        // add a top margin of 7
        p.setBorder(BorderFactory.createEmptyBorder(7, 0, 0, 0));
        p.add(addRecordButton);
        p.add(saveTo);
        add(p);

        // add a status bar
        p = new JPanel();
        p.setPreferredSize(new Dimension(340, 30));
        p.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        statusLabel = new JLabel("Status bar");
        p.add(statusLabel);
        add(p);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String digits = inputField.getText();
        if (e.getActionCommand() == "GENERATE WORDS") {

            if (!digits.matches("([2-9]{7})")) {
                // Notify the user about the error
                String msg = "Please enter a 7 digit number 2-9";
                JOptionPane.showMessageDialog(AppGuI.this, msg, "Invalid Number", JOptionPane.WARNING_MESSAGE);
                return;
            }

            ArrayList<String> wordsList = wordGenerator.fillWordList(digits);
            statusLabel.setText("Total words generated: " + wordsList.size());
            statusLabel.setForeground(Color.BLUE);
        } else {
            // save to file...
            // prompt the user to select a path to save
            // the generated words for a 7 digit number.
            JFileChooser fChooser = new JFileChooser(".");
            fChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int option = fChooser.showOpenDialog(AppGuI.this);
            if (JFileChooser.APPROVE_OPTION == option) {
                File file = fChooser.getSelectedFile();
                var name = file.getAbsolutePath() + "/words-" + digits + ".txt";
                try (PrintWriter writer = new PrintWriter(name)) {
                    wordGenerator.getWordList().forEach((word) -> {
                        writer.println(word);
                    });
                    // empty the list after saving
                    wordGenerator.clearList();
                    inputField.setText("");
                    statusLabel.setText("The words have been saved as words-" + digits + ".txt ");

                } catch (FileNotFoundException ex) {
                    // Notify the user about the error
                    String msg = "Please provide a valid directory path";
                    JOptionPane.showMessageDialog(AppGuI.this, msg, "Invalid Path", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

        }

    }

}
