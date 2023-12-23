package com.MobSOL.Enigmatica.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Requests {
    @JsonProperty("DigestEnc")
    private String DigestEnc;
    @JsonProperty("Type")
    private String Type;
    @JsonProperty("Digest")
    private String Digest;
    @JsonProperty("Key")
    private String Key;

    public Requests (){super();}

    public String getDigestEnc() {return DigestEnc;}
    public String getType() {return Type;}
    public String getDigest() {return Digest;}
    public String getKey() {return Key;}
}
