
#if [ $# -ne 2 || 1]; then
#    exit 1
#fi

usuarios=($(cut -d: -f1 /etc/passwd))

case $1 in
    "existe")
        for u in "$usuarios"; do
            if [ $2 == $u ]; then
                echo "el usuario existe"
                exit 0
            fi
        done
        exit 1
    ;;
    "eliminar_usuario")
        for u in "${#usuarios[@]}"; do
            if [ $2 == "{usuarios[$u]}" ]; then
                unset usuarios[$u]
                exit 0
            fi
        done
        exit 2
    ;;
    "usuarios_con_patron")
        encontrado=()
        for u in "${usuarios[@]}"; do
            if [ *"$2"* == "$u" ]; then
                encontrado+=$u
            fi
        done
        if [${#encontrados[@]} -eq 0]; then
            exit 102
        fi
        exit 0
    ;;
    "cantidad")
        echo "$(${#usuarios[@]})"
    ;;
    "usuarios")
        echo "$(${usuarios[@]})"
    ;;
    *)

    ;;
esac