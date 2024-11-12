
if [ $# -eq 0 ]; then
    exit 1
fi
cont=0
for i in "$@"; do
    if [ -e "$i" ]; then
        if [ -f "$i" ]; then
            gzip "$i"
        elif [ -d "$i" ]; then
            if [ -r "$i" ]; then
                tar "$i" | gzip
            else
                rm "$i"
            fi
        else
            cont+=1
        fi
    fi
done
echo "$cont no existen en el sistema de archivos"