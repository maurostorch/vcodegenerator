package com.storchti.codegenerator.gui;

import java.io.File;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.mvc.structure.DefaultController;

import com.storchti.codegenerator.CodeGenerator;
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
public abstract class CodeGenGuiController implements DefaultController{
	
	private JFileChooser fileChooser;
	private StringWriter codeOutput;
	
	public abstract CodeGenGuiModel getModel();
		
	public void generate(){
		CodeGenerator cg = new CodeGenerator(){

			@Override
			public ArrayList<ArrayList<String>> getInPut() {
				return getData();
			}

			@Override
			public Writer getOutPut() {
				return getWriter();
			}

			@Override
			public String getTemplate() {
				return getModel().getTemplateText();
			}
			
		};
		try {
			cg.generate();
			//new File("tempTemplate.txt").delete();
			getModel().setCodeText(codeOutput.toString());
			codeOutput.close();
			codeOutput = new StringWriter();
		} catch (Exception e) {
			showSendError(e.getMessage());
		}
	}
	
	public ArrayList<ArrayList<String>> getData(){
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for(String line: getModel().getDataText().split("\n")){
			ArrayList<String> l = new ArrayList<String>();
			for(String s: line.split(" +")){
				l.add(s);
			}
			list.add(l);
		}
		return list;
	}
	
	public Writer getWriter(){
		codeOutput = new StringWriter();
		return codeOutput;
	}
	
	public void saveTemplate(){
		int resul = getFileChooser().showSaveDialog(getModel().getParent());
		if(resul == JFileChooser.APPROVE_OPTION){
			try {
				IOManager iomanage = new IOManager();
				iomanage.writeUTF(getFileChooser().getSelectedFile(),getModel().getTemplateText());
				getModel().setTemplateFileName(getFileChooser().getSelectedFile().getAbsolutePath());
			} catch (Exception e) {
				showSendError(e.getMessage());
			}
			
		}
	}
	
	public void saveData(){
		int resul = getFileChooser().showSaveDialog(getModel().getParent());
		if(resul == JFileChooser.APPROVE_OPTION){
			try {
				IOManager iomanage = new IOManager();
				iomanage.writeUTF(getFileChooser().getSelectedFile(),getModel().getDataText());
				getModel().setDataFileName(getFileChooser().getSelectedFile().getAbsolutePath());
			} catch (Exception e) {
				showSendError(e.getMessage());
			}
			
		}
	}
	
	public void saveCode(){
		int resul = getFileChooser().showSaveDialog(getModel().getParent());
		if(resul == JFileChooser.APPROVE_OPTION){
			try {
				IOManager iomanage = new IOManager();
				iomanage.writeUTF(getFileChooser().getSelectedFile(),getModel().getCodeText());
			} catch (Exception e) {
				showSendError(e.getMessage());
			}
			
		}
	}
	
	public void searchData(){
		int resul = getFileChooser().showOpenDialog(getModel().getParent());
		if(resul == JFileChooser.APPROVE_OPTION){
			try {
				IOManager iomanage = new IOManager();
				getModel().setDataText(iomanage.readUTF(getFileChooser().getSelectedFile()));
				getModel().setDataFileName(getFileChooser().getSelectedFile().toString());
				//this.templateFileName = getFileChooser().getSelectedFile().toString().replaceAll("\\", "/");
			} catch (Exception e) {
				showSendError(e.getMessage());
			}
			
		}
	}
	
	public void searchTemplate(){
		int resul = getFileChooser().showOpenDialog(getModel().getParent());
		if(resul == JFileChooser.APPROVE_OPTION){
			try {
				IOManager iomanage = new IOManager();
				getModel().setTemplateText(iomanage.readUTF(getFileChooser().getSelectedFile()));
				getModel().setTemplateFileName(getFileChooser().getSelectedFile().toString());
				//this.templateFileName = getFileChooser().getSelectedFile().toString().replaceAll("\\", "/");
			} catch (Exception e) {
				showSendError(e.getMessage());
			}
			
		}
	}
	
	public JFileChooser getFileChooser() {
		if (fileChooser == null) {
			fileChooser = new JFileChooser();
			fileChooser.setMultiSelectionEnabled(false);
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
		}
		return fileChooser;
	}
	
	public void showSendError(String msg) {
		JOptionPane.showMessageDialog(getModel().getParent(), msg);
	}
	
	public void showCheckSave(){
		if (JOptionPane.showConfirmDialog(getModel().getParent(),
										  "Template is not saved! Save it?", 
										  "Save template file", 
										  JOptionPane.YES_NO_OPTION, 
										  JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			saveTemplate();
		}
	}

}
