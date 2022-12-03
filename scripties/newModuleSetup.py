#!/usr/bin/env python3

# This is one of the worst things I have ever created.

import os
import sys
from os import path
from string import Template

DEFAULT_MAIN_CLASS_NAME = "Main.java"
PACKAGE_START = "ca.terrylockett.aoc2022."

JAVA_FILE_TEMPLATE = """package $package;

public class $class_name {

    public static void main(String[] args) {
        //TODO Code
    }
    
}
"""

GRADLE_FILE_TEMPLATE = """dependencies {
}

application {
    mainClass = '$full_qualified_class_name'
}
"""

projectName = ''
projectPath = ''
className = ''


def main():
    if len(sys.argv) != 2:
        print("wrong number of arguments provided")
        print("example: ./newModuleSetup.py day02")
        sys.exit(1)

    global projectName
    projectName = sys.argv[1]

    global projectPath
    projectPath = "../" + projectName

    global className
    className = projectName.replace("d", "D") + "Runner"

    pre_checks()
    update_build_gradle()
    make_packages()
    make_main_class()


def pre_checks():
    if path.isdir(projectPath):
        print("\tDirectory " + projectPath + " exists")
    else:
        sys.exit("Error: Directory " + projectPath + " does not exist")


def update_build_gradle():
    build_gradle_file = projectPath + '/build.gradle'

    with open(build_gradle_file, 'w') as fp:
        fp.write(Template(GRADLE_FILE_TEMPLATE).substitute(
            full_qualified_class_name=PACKAGE_START + projectName + "." + className))


def make_packages():
    if not path.isdir(projectPath + "/src/main/java/ca/terrylockett/aoc2022/"):
        os.makedirs(projectPath + "/src/main/java/ca/terrylockett/aoc2022/" + projectName + "/")

    if not path.isdir(projectPath + "/src/test/java/ca/terrylockett/aoc2022/"):
        os.makedirs(projectPath + "/src/test/java/ca/terrylockett/aoc2022/" + projectName + "/")


def make_main_class():
    if path.isfile(projectPath + "/src/main/java/ca/terrylockett/Main.java"):
        os.remove(projectPath + "/src/main/java/ca/terrylockett/Main.java")

    main_file = projectPath + "/src/main/java/ca/terrylockett/aoc2022/" + projectName + "/" + className + ".java"

    if not path.isfile(main_file):
        with open(main_file, 'w') as fp:
            fp.write(Template(JAVA_FILE_TEMPLATE).substitute(
                package=PACKAGE_START + projectName,
                class_name=className))


main()
