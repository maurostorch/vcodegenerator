package com.storchti.codegenerator.gui;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
public class IOManager {

	public final void writeUTF(File file, String text) throws Exception {
		file.getParentFile().mkdirs();

		String lineSeparator = System.getProperty("line.separator");
		text = text.replaceAll("\n", lineSeparator);

		FileOutputStream fileOutputStream = new FileOutputStream(file);
		OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF8");
		BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

		bufferedWriter.write(text);
		bufferedWriter.close();
	}

	public final String readUTF(File file) throws Exception {

		FileInputStream fileInputStream = new FileInputStream(file);
		InputStreamReader InputStreamReader = new InputStreamReader(fileInputStream, "UTF8");
		BufferedReader bufferedReader = new BufferedReader(InputStreamReader);

		String lineText = "";
		String fullText = "";
		while ((lineText = bufferedReader.readLine()) != null) {
			fullText += (fullText == "" ? "" : "\n") + lineText;
		}

		bufferedReader.close();

		return fullText;
	}

}
