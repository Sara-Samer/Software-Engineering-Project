class Ad {
	private String header;
	private String[] headLines;
	private String[] textDescription;
	public Ad() {
		header = "";
		headLines = new String[2];
		textDescription = new String[4];
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public void setHeadLines(String[] headLines) {
		for(int i = 0 ; i < 2 ; i++)
			this.headLines[i] = headLines[i];
	}
	public void setTextDescription(String[] textDescription) {
		for(int i = 0 ; i < 4 ; i++)
			this.textDescription[i] = textDescription[i];
	}
	public String getHeader() {return this.header;}
	public String[] getHeadLines() {return this.headLines;}
	public String[] getTextDescription() {return this.textDescription;}
}
