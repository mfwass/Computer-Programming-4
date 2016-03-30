# taken from http://stackoverflow.com/questions/5411603/how-do-i-remove-trailing-whitespace-in-python-code-using-python-script

import os

for path, dirs, files in os.walk('../'):
    for f in files:
        file_name, file_extension = os.path.splitext(f)
        if file_extension == '.py':
            path_name = os.path.join(path, f)
            with open(path_name, 'r') as fh:
                new = [line.rstrip() for line in fh]
            with open(path_name, 'w') as fh:
                [fh.write('%s\n' % line) for line in new]
