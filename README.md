## AlphaZ copy to gitlab

This repository contains (partial) copy of source code for AlphaZ system 
developed at Colorado State University:
 http://www.cs.colostate.edu/AlphaZ/wiki/

The original repositories are scattered across two sites (CSU, Inria Forge), 
and the connection was not well maintained when projects hosted on Inria 
(shared with GeCoS project) were migrated to gitlab. This port of AlphaZ
includes all plugins that are no longer used by GeCoS and AlphaZ specific. 
All other plugins are fetched from new GeCoS update sites.

Follow the instructions below to install AlphaZ. It should work for Linux and Macos (64 bits only).

For examples of how to use AlphaZ, see the original wiki at CSU (linked above).
Also the test project contains many examples:
  https://gitlab.inria.fr/Alpha/alphaz/tree/master/tests/edu.csu.melange.alphaz.mde.tests

### Installation

1. Install Eclipse IDE for Java Developers. In the following version 2019-03 is
assumed.
2. Launch eclipse and select a fresh workspace.
3. ``Help -> Install new software``
   - Select "2019-03 - http://download.eclipse.org/releases/2019-03" as the repository to work with.
   - Search for "Xtext" and select ``Xtext Complete SDK`` and install.
   (you may find two or more, but pick one - it shows up under multiple categories, but they are the same thing)
4. ``Help -> Install new software``
   - Click on ``Add...`` to add a new repository: ``http://gecos.gforge.inria.fr/updatesite/gecos/``
   - Make sure "Work with:" points to the added repository 
   - Select the following:
       * EMF Tools
       * Framework
       * Graph Tools
       * JNI Mapper
       * Tom Mapping
       * Tom SDK
   - Install all of the above 
5. ``Help -> Install new software``
   - Click on ``Add...`` to add a new repository: ``http://people.irisa.fr/Tomofumi.Yuki/updatesite/alphaz/``
   - Make sure "Work with:" points to the added repository 
   - Select ``AlphaZ`` and install.

### Instructions for Installing from Source Code

1. Checkout AlphaZ projects from git repository (here).
2. Install Eclipse IDE for Java Developers. In the following version 2019-03 is
assumed.
3. Launch eclipse and select a fresh workspace.
4. Open ``Preferences -> Java -> Compiler`` and set ``Compiler compliance level`` to 1.8.
5. ``Help -> Install new software``
   - Select "2019-03 - http://download.eclipse.org/releases/2019-03" as the repository to work with.
   - Search for "Xtext" and select ``Xtext Complete SDK`` and install.
   (you may find two or more, but pick one - it shows up under multiple categories, but they are the same thing)
6. ``Help -> Install new software``
   - Click on ``Add...`` to add a new repository: ``http://gecos.gforge.inria.fr/updatesite/gecos/``
   - Make sure "Work with:" points to the added repository 
   - Select the following:
       * EMF Tools
       * Framework
       * Graph Tools
       * JNI Mapper
       * Tom Mapping
       * Tom SDK
   - Install all of the above 
7. Select ``Import projects -> General -> Existing Projects into Workspace``
    - Select root directory to be where the git repository was checked out
    - Import all projects

    