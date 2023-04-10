package me.obvgamer.obvclient.managers;

import me.obvgamer.obvclient.module.Category;
import me.obvgamer.obvclient.module.Module;
import me.obvgamer.obvclient.module.modules.render.Hitboxes;

import java.util.ArrayList;

public class ModuleManager {

    public ArrayList<Module> modules;

    public ModuleManager() {
        (modules = new ArrayList<Module>()).clear();
        modules.add(new Hitboxes());
    }

    public Module getModule(String name) {
        for (Module m : this.modules) if (m.getName().equalsIgnoreCase(name)) return m;
        return null;
    }

}