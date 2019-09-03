package me.Shogatsu.Managers;

import me.Shogatsu.Menu.ErrorMenu;
import me.Shogatsu.Menu.GameMenu;
import net.dv8tion.jda.core.entities.Member;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.Role;
import net.dv8tion.jda.core.entities.User;
import org.jetbrains.annotations.NotNull;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class GeneralManager {
    public GeneralManager() {
    }
    public String getMentionedRole(Message msg) {
        String roles;
        Role tempRoles;
        Member member = msg.getMentionedMembers().get(0);
        List rolesList = member.getRoles();

        if (!rolesList.isEmpty()) {
            tempRoles = (Role) rolesList.get(0);
            roles = tempRoles.getName();
            for (int i = 1; i < rolesList.size(); i++) {
                tempRoles = (Role) rolesList.get(i);
                roles += ", " + tempRoles.getName();
            }
        } else {
            roles = "No Roles";
            return roles;
        }
        return roles;
    }
    public String getGuildMembers(@NotNull List membersList) {
        String members;
        Member tempMembers;

        members = "";
        if (!membersList.isEmpty()) {
            tempMembers = (Member) membersList.get(0);
            members = tempMembers.getEffectiveName();
            for (int i = 1; i < membersList.size(); i++) {
                tempMembers = (Member) membersList.get(i);
                members += ", " + tempMembers.getEffectiveName();
            }
        }
        return members;
    }
}
