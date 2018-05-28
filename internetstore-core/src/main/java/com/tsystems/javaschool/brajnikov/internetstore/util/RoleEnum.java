package com.tsystems.javaschool.brajnikov.internetstore.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * The enum Role enum.
 */
@AllArgsConstructor
public enum RoleEnum {
    /**
     * Admin role.
     */
    admin("Admin"), /**
     * Manager role.
     */
    manager("Manager"), /**
     * User role.
     */
    user("User");
    @Getter
    private String description;

}
