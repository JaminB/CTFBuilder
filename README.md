CTFBuilder
==========

An API and GUI interface for building and tracking Capture the Flag Competitions.

Currently supports creating competitions remotely over UNAUTHENTICATED SMB Shares.

Package overview

utils
  Provides low level fileIO/encoding/decoding operations
  
admin.builder.actions
  Contains methods for creating, reading, updating, and deleting competition data.

gui
  Contains all the gui interfaces
  
gui.admin
  Contains the admin panel (Used for building and managing competitions)

gui.competitor
  Contains the competitor panel (Used for competing in competitions)
