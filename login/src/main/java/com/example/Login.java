package com.example;

public class Login {
    private String username;
    private String password;
    private int tentativasErradas;
    private static final int maxTentativas = 3;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
        this.tentativasErradas = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTentativasErradas() {
        return tentativasErradas;
    }

    public void setTentativasErradas(int tentativasErradas) {
        this.tentativasErradas = tentativasErradas;
    }

    public static int getMaxtentativas() {
        return maxTentativas;
    }

    public boolean logando(String user, String pass){
            if (tentativasErradas >= maxTentativas) {
                return false;
        }

        if (user.equals(username) && pass.equals(password)) {
            tentativasErradas = 0;
            return true;
        } else {
            tentativasErradas++;
            return false;
        }
    }
    public void resetTentativas(){
        tentativasErradas = 0;
    }
    
}
