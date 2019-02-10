FOR %%I IN (*.txt) DO (
native2ascii -encoding utf-8 %%I %%~nI.properties
)
