package com.example.authservice.clients;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Document
public class AuthClientDetails implements ClientDetails {
    private static final long serialVersionUID = 1L;
    private final boolean scoped = false;
    private final boolean autoApprove = true;
    private final Map<String, Object> additionalInfo = null;

    @Id
    private String id;

    private String clientId;

    private String clientSecret;

    private String grantTypes;

    private String scopes;

    private String resources;

    private String redirectUris;

    private Integer accessTokenValidity;

    private Integer refreshTokenValidity;

    private String additionalInformation;
    private boolean secretRequired = true;
    private Collection<GrantedAuthority> authorities = new HashSet<>();

    @Override
    public String getClientId() {
        return clientId;
    }

    @Override
    public Set<String> getResourceIds() {
        return splitted(this.resources);
    }

    private HashSet<String> splitted(String text) {
        return Optional.ofNullable(text)
          .map(splittableText -> {
              String[] split = splittableText.split(",");
              List<String> strings = Arrays.asList(split);
              return new HashSet<>(strings);
          })
          .orElse(null);
    }

    @Override
    public boolean isSecretRequired() {
        return secretRequired;
    }

    @Override
    public String getClientSecret() {
        return clientSecret;
    }

    @Override
    public boolean isScoped() {
        return scoped;
    }

    @Override
    public Set<String> getScope() {
        return splitted(scopes);
    }

    @Override
    public Set<String> getAuthorizedGrantTypes() {
        return splitted(grantTypes);
    }

    @Override
    public Set<String> getRegisteredRedirectUri() {
        return splitted(redirectUris);
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Integer getAccessTokenValiditySeconds() {
        return accessTokenValidity;
    }

    @Override
    public Integer getRefreshTokenValiditySeconds() {
        return refreshTokenValidity;
    }

    @Override
    public boolean isAutoApprove(String scope) {
        return autoApprove;
    }

    @Override
    public Map<String, Object> getAdditionalInformation() {
        return additionalInfo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public void setRedirectUris(String redirectUris) {
        this.redirectUris = redirectUris;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public boolean isAutoApprove() {
        return autoApprove;
    }

    public Map<String, Object> getAdditionalInfo() {
        return additionalInfo;
    }

    public String getId() {
        return id;
    }

    public String getGrantTypes() {
        return grantTypes;
    }

    public String getScopes() {
        return scopes;
    }

    public String getResources() {
        return resources;
    }

    public String getRedirectUris() {
        return redirectUris;
    }

    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setSecretRequired(boolean secretRequired) {
        this.secretRequired = secretRequired;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}