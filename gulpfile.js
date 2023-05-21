const gulp = require('gulp');
const sass = require('gulp-sass')(require('sass'));
const { exec } = require('child_process');
const sassdoc = require('gulp-sassdoc');

function compilarSCSS() {
    return gulp.src('./src/main/resources/static/scss/Style.scss') // Reemplaza 'ruta/del/archivo.scss' por la ruta a tu archivo SCSS
        .pipe(sass()) // Compilar SCSS a CSS
        .pipe(gulp.dest('./src/main/resources/static/css/')); // Reemplaza 'ruta/de/destino' por la ruta donde deseas guardar el archivo CSS compilado
}

function start() {
    return exec('mvnw spring-boot:run', (err, stdout, stderr) => {
        if (err) {
            console.error(err);
            return;
        }
        console.log(stdout);
        console.error(stderr);
    });
}

gulp.task('sassdoc', function() {
    return gulp.src('./src/main/resources/static/scss/Style.scss')
        .pipe(sassdoc({
            dest: './sassdoc'
        }));
});

gulp.task('load', start);

gulp.task('scss', compilarSCSS);
