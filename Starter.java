package com.company;

class Starter {
    private String lastLine = "";

    public void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < lastLine.length(); i++) {
                temp.append(" ");
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private byte anim;

    public void animate(String line) {
        switch (anim) {
            case 1:
                print("[ \\ ] " + line);
                break;
            case 2:
                print("[ | ] " + line);
                break;
            case 3:
                print("[ / ] " + line);
                break;
            default:
                anim = 0;
                print("[ - ] " + line);
        }
        anim++;
    }
}

class Load{
    public Load() throws InterruptedException {
        Starter starter = new Starter();
        for (int i = 0; i <= 10; i++) {
            starter.animate("Loading...");
            //simulate a piece of task
            Thread.sleep(400);
        }
    }
}