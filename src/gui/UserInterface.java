
package gui;

import image.operations.*;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;

import distance.function.CosineDistance;
import distance.function.EuclideanDistance;


public class UserInterface extends javax.swing.JFrame {
    
  
	private static final long serialVersionUID = 109480384;
	ArrayList<ImageCom> images;
  
    private UserInterface() {
        initComponents();
    }
    
    private static UserInterface INSTANCE = null;
    
    public static UserInterface getInstance(){
        if(INSTANCE==null) INSTANCE = new UserInterface();
        return INSTANCE;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    
    private void initComponents() {

        mainWindow = new javax.swing.JPanel();
        browseDir = new javax.swing.JButton();
        selectFeature = new javax.swing.JComboBox();
        selectFunction = new javax.swing.JComboBox();
        colorHistPanel = new javax.swing.JPanel();
        binField = new javax.swing.JTextField();
        cellField = new javax.swing.JTextField();
        binLabel = new javax.swing.JLabel();
        cellLabel = new javax.swing.JLabel();
        edgeHistPanel = new javax.swing.JPanel();
        blockSizeLabel = new javax.swing.JLabel();
        thresLabel = new javax.swing.JLabel();
        blockSizeField = new javax.swing.JTextField();
        thresField = new javax.swing.JTextField();
        dataSetScrollPanel = new javax.swing.JScrollPane();
        datasetPanel = new javax.swing.JPanel();
        retrieveScrollPanel = new javax.swing.JScrollPane();
        retrievedImagePanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainWindow.setBackground(new java.awt.Color(255, 255, 255));

        browseDir.setText("Select Dataset");
        browseDir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectDatasetActionPerformed(evt);
            }
        });
        
      
        selectFeature.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ColorHistogram", "EdgeHistogram" }));
        selectFeature.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        selectFunction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Euclidean Distance", "Cosine Distance"}));

        colorHistPanel.setBackground(new java.awt.Color(255, 255, 255));
        colorHistPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("ColorHistogramParam"));

        binField.setText("10");

        cellField.setText("5");

        binLabel.setText("Bins:");

        cellLabel.setText("Cells:");

        javax.swing.GroupLayout colorHistLayout = new javax.swing.GroupLayout(colorHistPanel);
        colorHistPanel.setLayout(colorHistLayout);
        colorHistLayout.setHorizontalGroup(
            colorHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorHistLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(colorHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(binLabel)
                    .addComponent(cellLabel))
                .addGap(20, 20, 20)
                .addGroup(colorHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cellField)
                    .addComponent(binField))
                .addContainerGap())
        );
        colorHistLayout.setVerticalGroup(
            colorHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(colorHistLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(colorHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(colorHistLayout.createSequentialGroup()
                        .addComponent(binLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cellLabel))
                    .addGroup(colorHistLayout.createSequentialGroup()
                        .addComponent(binField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cellField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        edgeHistPanel.setBackground(new java.awt.Color(255, 255, 255));
        edgeHistPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("EdgeHistogramParam"));

        blockSizeLabel.setText("Block Size:");

        thresLabel.setText("Threshold:");

        blockSizeField.setText("3");

        thresField.setText("0.4");

        javax.swing.GroupLayout edgeHistLayout = new javax.swing.GroupLayout(edgeHistPanel);
        edgeHistPanel.setLayout(edgeHistLayout);
        edgeHistLayout.setHorizontalGroup(
            edgeHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edgeHistLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(edgeHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blockSizeLabel)
                    .addComponent(thresLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(edgeHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thresField)
                    .addComponent(blockSizeField))
                .addContainerGap())
        );
        edgeHistLayout.setVerticalGroup(
            edgeHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(edgeHistLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(edgeHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blockSizeLabel)
                    .addComponent(blockSizeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(edgeHistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(thresLabel)
                    .addComponent(thresField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout leftSettingLayout = new javax.swing.GroupLayout(mainWindow);
        mainWindow.setLayout(leftSettingLayout);
        leftSettingLayout.setHorizontalGroup(
            leftSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSettingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(leftSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(browseDir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectFeature, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectFunction, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(colorHistPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edgeHistPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        leftSettingLayout.setVerticalGroup(
            leftSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSettingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(browseDir)           
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectFeature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectFunction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(colorHistPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edgeHistPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dataSetScrollPanel.setBackground(new java.awt.Color(255, 255, 255));

        datasetPanel.setBackground(new java.awt.Color(255, 255, 255));
        dataSetScrollPanel.setViewportView(datasetPanel);

        retrieveScrollPanel.setViewportView(retrievedImagePanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)                    
                    .addComponent(colorHistPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(edgeHistPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))                
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainWindow, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                		
                    .addComponent(dataSetScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                    .addComponent(retrieveScrollPanel))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainWindow, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dataSetScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(retrieveScrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }

    private void jButtonSelectDatasetActionPerformed(java.awt.event.ActionEvent evt) {
        datasetPanel.removeAll();
        
        ImageImporter importer = new ImageImporter();
        JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int showOpenDialog = fc.showOpenDialog(this);
        if(showOpenDialog==JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            importer.importImage(file);
        } else{
            System.out.println("ERROR: No File/Directory selected");
        }
        
        
        this.images = importer.images;
        
        for (int i = 0; i < images.size(); i++) {
            System.out.println("Loading Image "+i);
            ImageCom get = images.get(i);
            
            Image scaledInstance = get.image.getScaledInstance(datasetPanel.getHeight()-25, datasetPanel.getHeight()-25, Image.SCALE_FAST);
            ImageLabel l = new ImageLabel(get, new ImageIcon(scaledInstance));
            l.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    UserInterface.getInstance().query(((ImageLabel)e.getSource()).imageFile);
                }
            });
            datasetPanel.add(l);            
        }    
        datasetPanel.revalidate();
        
        System.out.println("Dataset Loaded.");
    }

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
   
    @SuppressWarnings("unused")
	private ImageCom currentQueryImage;
    
    public void query(ImageCom imageFile){
        currentQueryImage = imageFile;
        
        String feature = (String)selectFeature.getSelectedItem();
        String distance = (String)selectFunction.getSelectedItem();
        System.out.println(feature +", "+distance);
        
        for (int i = 0; i < images.size(); i++) {
            System.out.println("Generating Feature Vector for Image # "+i);
            if(feature.equals("ColorHistogram")) images.get(i).setFeature(feature, Double.valueOf(binField.getText()), Double.valueOf(cellField.getText()));
            if(feature.equals("EdgeHistogram")) images.get(i).setFeature(feature, Double.valueOf(blockSizeField.getText()), Double.valueOf(thresField.getText()));
        }
        
        retrievedImagePanel.removeAll();
        
        //query image       
        double[][] query = imageFile.featureVector;
        
        for (int i = 0; i < images.size(); i++) {
            System.out.println("Calculating Distance for Image # "+i);
            ImageCom get = images.get(i);
            switch(distance){
                case "Euclidean Distance": get.setDistance(EuclideanDistance.calculateEuclidianDistance(query, get.featureVector)); break;
                case "Cosine Distance": get.setDistance(CosineDistance.calculateCosineDistance(query, get.featureVector)); break;
            }
            
        }
        
        Collections.sort(images);
        
        
        
        for (int i = 0; i < images.size(); i++) {
            System.out.println("Loading Result Image "+i);
            ImageCom get = images.get(i);
            Image scaledInstance = get.image.getScaledInstance(retrievedImagePanel.getHeight()-25, retrievedImagePanel.getHeight()-25, Image.SCALE_FAST);
            JLabel l = new JLabel(new ImageIcon(scaledInstance));
            retrievedImagePanel.add(l);
        }
        retrievedImagePanel.revalidate();
    }
    
   
   
    
    private javax.swing.JButton browseDir;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox selectFeature;
    @SuppressWarnings("rawtypes")
	private javax.swing.JComboBox selectFunction;
    private javax.swing.JLabel binLabel;
    private javax.swing.JLabel cellLabel;
    private javax.swing.JLabel blockSizeLabel;
    private javax.swing.JLabel thresLabel;
    private javax.swing.JPanel mainWindow;
    private javax.swing.JPanel datasetPanel;
    private javax.swing.JPanel retrievedImagePanel;
    private javax.swing.JPanel colorHistPanel;
    private javax.swing.JPanel edgeHistPanel;
    private javax.swing.JScrollPane dataSetScrollPanel;
    private javax.swing.JScrollPane retrieveScrollPanel;
    private javax.swing.JTextField binField;
    private javax.swing.JTextField cellField;
    private javax.swing.JTextField blockSizeField;
    private javax.swing.JTextField thresField;
    
}
