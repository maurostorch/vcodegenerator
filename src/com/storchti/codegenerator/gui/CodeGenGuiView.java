package com.storchti.codegenerator.gui;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

import org.mvc.structure.DefaultView;
/*
 * Copyright [2008] [Mauro Storch]
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 		http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 */

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class CodeGenGuiView extends JFrame implements DefaultView<CodeGenGuiModel, CodeGenGuiController>{

	private static final long serialVersionUID = 1L;
	private boolean CHECK_SAVE = false;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JButton jButtonCodeSave;
	private JButton jButtonSearch;
	private JTextField jTextFieldTemplateFile;
	private JPanel jPanel5;
	private JPanel jPanel4;
	private JPanel jPanel3;
	private JPanel jPanel2;
	private JPanel jPanel1;
	private JTextArea jTextAreaData;
	private JTextArea jTextAreaTemplate;
	private JTextArea jTextAreaCode;
	private JScrollPane jScrollPane3;
	private JSplitPane jSplitPane1;
	private JSplitPane jSplitPane;
	private JButton jButtonGenerate;
	private CodeGenGuiModel model;
	private JButton jButton1;
	private JPanel jPanel8;
	private JLabel jLabelPosition;
	private JLabel jLabelStatus;
	private JPanel jPanel7;
	private JButton jButtonSaveData;
	private JButton jButtonSaveTemplate;
	private JButton jButtonSearchData;
	private JTextField jTextFieldDataFilename;
	private JPanel jPanel6;
	private CodeGenGuiController controller;
	
	
	public CodeGenGuiView() {
		super("JCodeGenerator");
		initGUI();
	}
	
	public static void main(String args[]){
		CodeGenGuiView inst = new CodeGenGuiView();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}
	
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			thisLayout.rowWeights = new double[] {0.1, 0.0};
			thisLayout.rowHeights = new int[] {7, 20};
			thisLayout.columnWeights = new double[] {0.1};
			thisLayout.columnWidths = new int[] {7};
			getContentPane().setLayout(thisLayout);
			getContentPane().add(getJSplitPane(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			getContentPane().add(getJPanel7(), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			pack();
			this.setSize(800, 627);
			this.addWindowListener(new WindowListener(){
				@Override
				public void windowActivated(WindowEvent e) {}
				@Override
				public void windowClosed(WindowEvent e) {}
				@Override
				public void windowClosing(WindowEvent e) {
					if (CHECK_SAVE){
						getController().showCheckSave();
					}					
				}
				@Override
				public void windowDeactivated(WindowEvent e) {}
				@Override
				public void windowDeiconified(WindowEvent e) {}
				@Override
				public void windowIconified(WindowEvent e) {}
				@Override
				public void windowOpened(WindowEvent e) {}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CodeGenGuiController getController() {
		if(controller == null){
			controller = new CodeGenGuiController(){

				@Override
				public CodeGenGuiModel getModel() {
					return CodeGenGuiView.this.getModel();
				}
				
			};
		}
		return controller;
	}

	@Override
	public CodeGenGuiModel getModel() {
		if(model == null){
			model = new CodeGenGuiModel(){

				@Override
				public String getCodeText() {
					return getJTextAreaCode().getText();
				}

				@Override
				public String getDataFileName() {
					return getJTextFieldDataFilename().getText();
				}

				@Override
				public String getDataText() {
					return getJTextAreaData().getText();
				}

				@Override
				public Component getParent() {
					return CodeGenGuiView.this;
				}

				@Override
				public String getTemplateFileName() {
					return getJTextFieldTemplateFile().getText();
				}

				@Override
				public String getTemplateText() {
					return getJTextAreaTemplate().getText();
				}

				@Override
				public void setCodeText(String code) {
					getJTextAreaCode().setText(code);
				}

				@Override
				public void setDataFileName(String filename) {
					getJTextFieldDataFilename().setText(filename);
				}

				@Override
				public void setDataText(String data) {
					getJTextAreaData().setText(data);
				}

				@Override
				public void setTemplateFileName(String filename) {
					getJTextFieldTemplateFile().setText(filename);
				}

				@Override
				public void setTemplateText(String template) {
					getJTextAreaTemplate().setText(template);
				}

			};
		}
		return model;
	}

	@Override
	public void setModel(CodeGenGuiModel model) {
		if (model != null) {
			getModel().fromObject(model.toObject());
		}		
	}
	
	private void jButtonGenerateActionPerformed(ActionEvent evt){
		getController().generate();
	}
	
	private JButton getJButtonGenerate() {
		if(jButtonGenerate == null) {
			jButtonGenerate = new JButton();
			jButtonGenerate.setText("Generate");
			jButtonGenerate.setSize(59, 23);
			jButtonGenerate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonGenerateActionPerformed(evt);
				}
			});
		}
		return jButtonGenerate;
	}
	
	private JSplitPane getJSplitPane() {
		if(jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			jSplitPane.add(getJSplitPane1(), JSplitPane.BOTTOM);
			jSplitPane.add(getJPanel3(), JSplitPane.LEFT);
			jSplitPane.setDividerLocation(200);
		}
		return jSplitPane;
	}

	private JSplitPane getJSplitPane1() {
		if(jSplitPane1 == null) {
			jSplitPane1 = new JSplitPane();
			jSplitPane1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			jSplitPane1.setDividerLocation(100);
			jSplitPane1.add(getJPanel1(), JSplitPane.BOTTOM);
			jSplitPane1.add(getJPanel2(), JSplitPane.TOP);
			jSplitPane1.setDividerLocation(200);
		}
		return jSplitPane1;
	}
	
	private JScrollPane getJScrollPane1() {
		if(jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jScrollPane1.setPreferredSize(new java.awt.Dimension(790, 199));
			jScrollPane1.setViewportView(getJTextAreaData());
		}
		return jScrollPane1;
	}
	
	private JScrollPane getJScrollPane2() {
		if(jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jScrollPane2.setPreferredSize(new java.awt.Dimension(788, 323));
			jScrollPane2.setViewportView(getJTextAreaCode());
		}
		return jScrollPane2;
	}
	
	private JScrollPane getJScrollPane3() {
		if(jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
			jScrollPane3.setPreferredSize(new java.awt.Dimension(788, 323));
			jScrollPane3.setViewportView(getJTextAreaTemplate());
		}
		return jScrollPane3;
	}

	private JTextArea getJTextAreaTemplate() {
		if(jTextAreaTemplate == null) {
			jTextAreaTemplate = new JTextArea();
			jTextAreaTemplate.setText("#foreach($line in $document.Lines)\n" +
					"private $line.getColumn(0) $line.getColumn(1);\n" +
					"\n" +
					"public $line.getColumn(0) get$util.firstToUpperCase($line.getColumn(1))(){\n"+
					"  return $line.getColumn(1);\n"+
					"}\n"+
					"public void set$util.firstToUpperCase($line.getColumn(1))($line.getColumn(0) $line.getColumn(1)){\n"+
					"  this.$line.getColumn(1) = $line.getColumn(1);\n"+
					"}\n"+
					"#end");
			jTextAreaTemplate.setBorder(BorderFactory.createTitledBorder(""));
			jTextAreaTemplate.setFont(new java.awt.Font("Courier New",0,13));
			jTextAreaTemplate.addKeyListener(new KeyListener(){
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == 88){
						getController().generate();
					}
				}
				@Override
				public void keyReleased(KeyEvent e) {
					getJLabelPosition().setText("Position:"+getCursorPosition(getJTextAreaTemplate().getCaretPosition()));
				}
				@Override
				public void keyTyped(KeyEvent e) {
					CHECK_SAVE = true;
				}
			});
			jTextAreaTemplate.addMouseListener(new MouseListener(){
				@Override
				public void mouseClicked(MouseEvent e) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				@Override
				public void mousePressed(MouseEvent e) {}
				@Override
				public void mouseReleased(MouseEvent e) {
					getJLabelPosition().setText("Position:"+getCursorPosition(getJTextAreaTemplate().getCaretPosition()));
				}
			});
		}
		return jTextAreaTemplate;
	}
	
	private JTextArea getJTextAreaCode() {
		if(jTextAreaCode == null) {
			jTextAreaCode = new JTextArea();
			jTextAreaCode.setText("Clic on Generate or press Ctrl+x");
			jTextAreaCode.setBorder(BorderFactory.createTitledBorder(""));
			jTextAreaCode.setEditable(false);
			jTextAreaCode.setFont(new java.awt.Font("Courier New",0,13));
		}
		return jTextAreaCode;
	}

	private JTextArea getJTextAreaData() {
		if(jTextAreaData == null) {
			jTextAreaData = new JTextArea();
			jTextAreaData.setText("String a");
			jTextAreaData.setFont(new java.awt.Font("Courier New",0,13));
		}
		return jTextAreaData;
	}
	
	private JPanel getJPanel1() {
		if(jPanel1 == null) {
			jPanel1 = new JPanel();
			GridBagLayout jPanel1Layout = new GridBagLayout();
			jPanel1Layout.rowWeights = new double[] {0.0, 0.1};
			jPanel1Layout.rowHeights = new int[] {7, 7};
			jPanel1Layout.columnWeights = new double[] {0.1};
			jPanel1Layout.columnWidths = new int[] {7};
			jPanel1.setLayout(jPanel1Layout);
			jPanel1.add(getJScrollPane2(), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanel1.add(getJPanel4(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanel1;
	}
	
	private JPanel getJPanel2() {
		if(jPanel2 == null) {
			jPanel2 = new JPanel();
			GridBagLayout jPanel2Layout = new GridBagLayout();
			jPanel2Layout.rowWeights = new double[] {0.0, 0.1};
			jPanel2Layout.rowHeights = new int[] {7, 7};
			jPanel2Layout.columnWeights = new double[] {0.1};
			jPanel2Layout.columnWidths = new int[] {7};
			jPanel2.setLayout(jPanel2Layout);
			jPanel2.add(getJScrollPane3(), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanel2.add(getJPanel5(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanel2;
	}
	
	private JPanel getJPanel3() {
		if(jPanel3 == null) {
			jPanel3 = new JPanel();
			GridBagLayout jPanel3Layout = new GridBagLayout();
			jPanel3Layout.rowWeights = new double[] {0.0, 0.1};
			jPanel3Layout.rowHeights = new int[] {7, 7};
			jPanel3Layout.columnWeights = new double[] {0.1};
			jPanel3Layout.columnWidths = new int[] {7};
			jPanel3.setLayout(jPanel3Layout);
			jPanel3.add(getJScrollPane1(), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
			jPanel3.add(getJPanel6(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanel3;
	}
	
	private JPanel getJPanel4() {
		if(jPanel4 == null) {
			jPanel4 = new JPanel();
			GridBagLayout jPanel4Layout = new GridBagLayout();
			jPanel4Layout.rowWeights = new double[] {0.1};
			jPanel4Layout.rowHeights = new int[] {7};
			jPanel4Layout.columnWeights = new double[] {0.1, 0.1, 0.0, 0.0};
			jPanel4Layout.columnWidths = new int[] {7, 20, 7, 7};
			jPanel4.setLayout(jPanel4Layout);
			jPanel4.add(getJButtonCodeSave(), new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel4.add(getJButtonGenerate(), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel4.add(getJButton1(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanel4;
	}
	private JButton getJButtonCodeSave() {
		if(jButtonCodeSave == null) {
			jButtonCodeSave = new JButton();
			jButtonCodeSave.setText("Save");
			jButtonCodeSave.setSize(59, 23);
			jButtonCodeSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonCodeSaveActionPerformed(evt);
				}
			});
		}
		return jButtonCodeSave;
	}
	
	private JPanel getJPanel5() {
		if(jPanel5 == null) {
			jPanel5 = new JPanel();
			GridBagLayout jPanel5Layout = new GridBagLayout();
			jPanel5Layout.rowWeights = new double[] {0.1};
			jPanel5Layout.rowHeights = new int[] {7};
			jPanel5Layout.columnWeights = new double[] {0.1, 0.1, 0.0, 0.0};
			jPanel5Layout.columnWidths = new int[] {20, 7, 7, 20};
			jPanel5.setLayout(jPanel5Layout);
			jPanel5.add(getJTextFieldTemplateFile(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			jPanel5.add(getJButtonSearch(), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel5.add(getJButtonSaveTemplate(), new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel5.add(getJPanel8(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanel5;
	}
	
	private JTextField getJTextFieldTemplateFile() {
		if(jTextFieldTemplateFile == null) {
			jTextFieldTemplateFile = new JTextField();
			jTextFieldTemplateFile.setText("template.txt");
			jTextFieldTemplateFile.setEditable(false);
		}
		return jTextFieldTemplateFile;
	}
	
	private JButton getJButtonSearch() {
		if(jButtonSearch == null) {
			jButtonSearch = new JButton();
			jButtonSearch.setText("Search");
			jButtonSearch.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonSearchActionPerformed(evt);
				}
			});
		}
		return jButtonSearch;
	}
	
	private JPanel getJPanel6() {
		if(jPanel6 == null) {
			jPanel6 = new JPanel();
			GridBagLayout jPanel6Layout = new GridBagLayout();
			jPanel6Layout.rowWeights = new double[] {0.1};
			jPanel6Layout.rowHeights = new int[] {7};
			jPanel6Layout.columnWeights = new double[] {0.1, 0.0, 0.0, 0.0};
			jPanel6Layout.columnWidths = new int[] {20, 363, 7, 20};
			jPanel6.setLayout(jPanel6Layout);
			jPanel6.add(getJTextFieldDataFilename(), new GridBagConstraints(1, -1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
			jPanel6.add(getJButtonSearchData(), new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel6.add(getJButtonSaveData(), new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanel6;
	}
	
	private JTextField getJTextFieldDataFilename() {
		if(jTextFieldDataFilename == null) {
			jTextFieldDataFilename = new JTextField();
			jTextFieldDataFilename.setText("data.txt");
			jTextFieldDataFilename.setEditable(false);
		}
		return jTextFieldDataFilename;
	}
	
	private JButton getJButtonSearchData() {
		if(jButtonSearchData == null) {
			jButtonSearchData = new JButton();
			jButtonSearchData.setText("Search");
			jButtonSearchData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonSearchDataActionPerformed(evt);
				}
			});
		}
		return jButtonSearchData;
	}
		
	private void jButtonSearchDataActionPerformed(ActionEvent evt) {
		getController().searchData();
	}
	
	private void jButtonSearchActionPerformed(ActionEvent evt) {
		getController().searchTemplate();
	}
	
	private void jButtonCodeSaveActionPerformed(ActionEvent evt) {
		getController().saveCode();
	}
	
	private JButton getJButtonSaveTemplate() {
		if(jButtonSaveTemplate == null) {
			jButtonSaveTemplate = new JButton();
			jButtonSaveTemplate.setText("Save");
			jButtonSaveTemplate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonSaveTemplateActionPerformed(evt);
				}
			});
		}
		return jButtonSaveTemplate;
	}
	
	private void jButtonSaveTemplateActionPerformed(ActionEvent evt) {
		getController().saveTemplate();
		CHECK_SAVE = false;
	}
	
	private JButton getJButtonSaveData() {
		if(jButtonSaveData == null) {
			jButtonSaveData = new JButton();
			jButtonSaveData.setText("Save");
			jButtonSaveData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonSaveDataActionPerformed(evt);
				}
			});
		}
		return jButtonSaveData;
	}
	
	private void jButtonSaveDataActionPerformed(ActionEvent evt) {
		getController().saveData();
	}

	private JPanel getJPanel7() {
		if(jPanel7 == null) {
			jPanel7 = new JPanel();
			GridBagLayout jPanel7Layout = new GridBagLayout();
			jPanel7Layout.rowWeights = new double[] {0.1};
			jPanel7Layout.rowHeights = new int[] {7};
			jPanel7Layout.columnWeights = new double[] {0.1, 0.1, 0.1};
			jPanel7Layout.columnWidths = new int[] {7, 7, 7};
			jPanel7.setLayout(jPanel7Layout);
			jPanel7.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
			jPanel7.add(getJLabelStatus(), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
			jPanel7.add(getJLabelPosition(), new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		}
		return jPanel7;
	}
	
	private JLabel getJLabelStatus() {
		if(jLabelStatus == null) {
			jLabelStatus = new JLabel();
			jLabelStatus.setText("Ctrl+x - Code Generation");
		}
		return jLabelStatus;
	}
	
	private JLabel getJLabelPosition() {
		if(jLabelPosition == null) {
			jLabelPosition = new JLabel();
			jLabelPosition.setText("Position:1:1");
		}
		return jLabelPosition;
	}
	
	private String getCursorPosition(int currentPosition){
		currentPosition = getJTextAreaTemplate().getCaretPosition();
		String[] text = getJTextAreaTemplate().getText().split("\n");
		int soma=0, i;
		
		for (i=0; i<=text.length-1; i++){
			if ((soma + text[i].length()) >= currentPosition)
				break;
			else{
				soma +=text[i].length()+1;
			}
		}
		int line = i+1;
		int col = (currentPosition) - soma;
		return line+":"+col;
	}
	
	private JPanel getJPanel8() {
		if(jPanel8 == null) {
			jPanel8 = new JPanel();
			GridBagLayout jPanel8Layout = new GridBagLayout();
			jPanel8Layout.rowWeights = new double[] {0.1};
			jPanel8Layout.rowHeights = new int[] {7};
			jPanel8Layout.columnWeights = new double[] {0.1, 0.1, 0.1, 0.1};
			jPanel8Layout.columnWidths = new int[] {7, 7, 7, 7};
			jPanel8.setLayout(jPanel8Layout);
		}
		return jPanel8;
	}
	
	private JButton getJButton1() {
		if(jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Clear");
			jButton1.setSize(59, 23);
			jButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButton1ActionPerformed(evt);
				}
			});
		}
		return jButton1;
	}
	
	private void jButton1ActionPerformed(ActionEvent evt) {
		getJTextAreaCode().setText("");
	}

}
