package com.storchti.codegenerator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
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
public class CodeGenConsole {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		if (args.length != 3) {
			System.out
					.println("Use: CodeGenConsole <dataFile> <templateFile> <outFile>");
			System.exit(0);
		}

		String datafile = args[0];
		final String templatefile = args[1];
		String outfile = args[2];
		final BufferedWriter writer = new BufferedWriter(new FileWriter(outfile));
		BufferedReader reader = new BufferedReader(new FileReader(datafile));
		BufferedReader templfile = new BufferedReader(new FileReader(templatefile));

		final ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		String local;
		while ((local = reader.readLine()) != null) {
			ArrayList<String> linha = new ArrayList<String>();
			for (String s : local.split(" +")) {
				linha.add(s);
			}
			list.add(linha);
		}
		local = "";
		String template = "";
		while ((local = templfile.readLine()) != null) {
			template += (template == "" ? "" : "\n") + local;
		}
		final String templ = template;

		CodeGenerator cg = new CodeGenerator() {

			@Override
			public ArrayList<ArrayList<String>> getInPut() {
				return list;
			}

			@Override
			public Writer getOutPut() {
				return writer;
			}

			@Override
			public String getTemplate() {
				return templ;
			}

		};

		try {
			cg.generate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		writer.flush();
		writer.close();
		reader.close();
		templfile.close();

	}

}
